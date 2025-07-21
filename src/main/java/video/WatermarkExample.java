package video;

import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class WatermarkExample {
    public static void main(String[] args) {
        String inputVideoPath = "/Users/sgz/Downloads/未压缩视频270MB.mp4";
        String outputVideoPath = "/Users/sgz/Downloads/out.mp4";
        addTextWatermark(inputVideoPath, outputVideoPath, "2025-7-21 10:00:00");
    }

    public static void addTextWatermark(String inputFilePath, String outputFilePath, String watermarkText) {
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputFilePath);
        FFmpegFrameRecorder recorder = null;

        try {
            grabber.start();

            // 1. 获取原始视频方向信息
            int rotation = 0;
            if (grabber.getVideoMetadata() != null && grabber.getVideoMetadata().containsKey("rotate")) {
                rotation = Integer.parseInt(grabber.getVideoMetadata().get("rotate").toString());
            }

            // 2. 使用原始宽高（不交换）
            int originalWidth = grabber.getImageWidth();
            int originalHeight = grabber.getImageHeight();
            int recorderWidth = originalWidth;
            int recorderHeight = originalHeight;

            // 根据旋转角度交换宽高
            if (rotation == 90 || rotation == 270) {
                recorderWidth = originalHeight;
                recorderHeight = originalWidth;
            }

            // 3. 初始化录制器（使用原始宽高）
            recorder = new FFmpegFrameRecorder(outputFilePath, recorderWidth, recorderHeight);
            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
            recorder.setFormat("mp4");
            recorder.setFrameRate(grabber.getFrameRate());
            recorder.setVideoBitrate(grabber.getVideoBitrate());
            recorder.setVideoQuality(0);
            recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);

            // 设置旋转元数据，让播放器处理旋转
            if (rotation != 0) {
                recorder.setMetadata("rotate", String.valueOf(rotation));
            }

            // 优化参数
            recorder.setVideoOption("preset", "fast");
            recorder.setVideoOption("tune", "zerolatency");
            recorder.setVideoOption("threads", "2");

            // 音频设置
            if (grabber.getAudioChannels() > 0) {
                recorder.setAudioCodec(avcodec.AV_CODEC_ID_AAC);
                recorder.setAudioChannels(grabber.getAudioChannels());
                recorder.setSampleRate(grabber.getSampleRate());
            }

            recorder.start();

            // 4. 水印处理
            Java2DFrameConverter converter = new Java2DFrameConverter();
            int fontSize = Math.max(12, Math.min(recorderWidth, recorderHeight) / 20);
            Font watermarkFont = new Font("微软雅黑", Font.PLAIN, fontSize);

            // 预计算水印位置（基于原始方向）
//            BufferedImage tempImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
//            Graphics2D tempG2d = tempImage.createGraphics();
//            FontMetrics metrics = tempG2d.getFontMetrics(watermarkFont);
//            int x = 20;
//            int y = 20 + metrics.getAscent();
//            tempG2d.dispose();

            // 5. 处理每一帧
            Frame frame;
            while ((frame = grabber.grab()) != null) {
                if (frame.image != null) {
                    BufferedImage image = converter.convert(frame);
                    if (image != null) {
                        // 第一步：先根据 rotation 实际旋转图像数据
                        if (rotation == 90 || rotation == 270) {
                            AffineTransform transform = new AffineTransform();
                            if (rotation == 90) {
                                transform.rotate(Math.toRadians(90), image.getWidth() / 2, image.getHeight() / 2);
                            } else {
                                transform.rotate(Math.toRadians(270), image.getWidth() / 2, image.getHeight() / 2);
                            }
                            AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
                            image = op.filter(image, null);
                        }

                        // 第二步：在旋转后的图像上添加水印（此时宽高已交换）
                        Graphics2D g2d = image.createGraphics();
                        g2d.setColor(new Color(255, 0, 0, 180));
                        g2d.setFont(watermarkFont);

                        // 重新计算水印位置（基于旋转后的图像）
                        FontMetrics metrics = g2d.getFontMetrics();
                        int newX = 20;
                        int newY = 20 + metrics.getAscent();

                        g2d.drawString(watermarkText, newX, newY);
                        g2d.dispose();

                        frame = converter.convert(image);
                    }
                }
                recorder.record(frame);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (recorder != null) {
                    recorder.close();
                }
                grabber.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
