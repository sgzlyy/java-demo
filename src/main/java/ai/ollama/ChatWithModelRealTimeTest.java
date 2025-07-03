package ai.ollama;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 实时与Model聊天
 */
public class ChatWithModelRealTimeTest {
    public static void main(String[] args) {
        // 创建一个ObjectMapper实例
        ObjectMapper objectMapper = new ObjectMapper();
        // 用于存储对话历史记录
        List<JsonNode> messages = new ArrayList<>();
        // 创建一个Scanner对象以读取用户输入
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // 提示用户输入
                System.out.print("你: ");
                String userInput = scanner.nextLine();

                // 将用户输入添加到对话历史记录中
                JsonNode userMessage = objectMapper.createObjectNode()
                        .put("role", "user")
                        .put("content", userInput);
                messages.add(userMessage);

                // 设置请求的URL
                URL url = new URL("http://localhost:11434/api/chat");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // 设置请求方法为POST
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json; utf-8");

                // 创建JSON格式的请求体
                JsonNode requestBody = objectMapper.createObjectNode()
                        .put("model", "deepseek-r1:1.5b")
                        .putPOJO("messages", messages)
                        .put("stream", false); // 设置为非流式返回结果，默认为true

                // 将请求体对象转换为JSON字符串
                String jsonInputString = objectMapper.writeValueAsString(requestBody);

                // 输出请求体
                System.out.println("Request Body: " + jsonInputString);

                // 将请求体写入输出流
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = objectMapper.writeValueAsBytes(requestBody);
                    os.write(input, 0, input.length);
                }

                // 读取响应
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    StringBuilder fullResponse = new StringBuilder();

                    // 处理响应
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                        String responseLine;
                        while ((responseLine = br.readLine()) != null) {
                            // 解析每一行JSON响应
                            JsonNode jsonNode = objectMapper.readTree(responseLine);
                            // 获取"message"中的"content"字段的值并拼接
                            if (jsonNode.has("message") && jsonNode.get("message").has("content")) {
                                String assistantResponse = jsonNode.get("message").get("content").asText();
                                fullResponse.append(assistantResponse);
                                // 将助手的回复添加到对话历史记录中
                                JsonNode assistantMessage = objectMapper.createObjectNode()
                                        .put("role", "assistant")
                                        .put("content", assistantResponse);
                                messages.add(assistantMessage);
                            }
                            // 检查"done"字段的值
                            if (jsonNode.has("done") && jsonNode.get("done").asBoolean()) {
                                break; // 如果"done"为true，结束循环
                            }
                        }
                    }

                    // 输出拼接后的完整响应
                    System.out.println("模型: " + fullResponse.toString());
                } else {
                    System.out.println("请求失败，响应代码: " + responseCode);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
