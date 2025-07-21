package video;

import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FfmpegDemo {
    public static void addWatermark(String inputPath, String outputPath) throws Exception {
        // 设置日志级别
        avutil.av_log_set_level(avutil.AV_LOG_INFO);
        
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(inputPath);
        grabber.start();
        
        // 获取视频参数
        int width = grabber.getImageWidth();
        int height = grabber.getImageHeight();
        int audioChannels = grabber.getAudioChannels();
        
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(
            outputPath, 
            width, 
            height, 
            audioChannels
        );
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
        recorder.setFormat("mp4");
        recorder.setFrameRate(grabber.getFrameRate());
        recorder.setVideoBitrate(grabber.getVideoBitrate());
        recorder.start();
        
        Frame frame;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        while ((frame = grabber.grab()) != null) {
            if (frame.image != null) {
                // 为每一帧添加水印
                String timeText = sdf.format(new Date());
                String addressText = "上海市浦东新区";
                
                java.awt.image.BufferedImage bi = org.bytedeco.javacv.Java2DFrameUtils.toBufferedImage(frame);
                java.awt.Graphics2D g2d = bi.createGraphics();
                g2d.setFont(new java.awt.Font("微软雅黑", java.awt.Font.PLAIN, 24));
                g2d.setColor(new java.awt.Color(255, 0, 0));
                
                // 绘制第一行水印(时间)
                g2d.drawString(timeText, 10, 30);
                // 绘制第二行水印(地址)
                g2d.drawString(addressText, 10, 60);
                
                g2d.dispose();
                frame = org.bytedeco.javacv.Java2DFrameUtils.toFrame(bi);
            }
            
            recorder.record(frame);
        }
        
        recorder.close();
        grabber.close();
    }
    
    public static void main(String[] args) {
        try {
            String inputVideoPath = "/Users/sgz/Downloads/1895220241969984_IOEE6OMO.mp4";
            String outputVideoPath = "/Users/sgz/Downloads/out.mp4";
            // 计算消耗时间
            long startTime = System.currentTimeMillis();
            addWatermark(inputVideoPath, outputVideoPath);
            System.out.println("视频水印添加完成");
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}