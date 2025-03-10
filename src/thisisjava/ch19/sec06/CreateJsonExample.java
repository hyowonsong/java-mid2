package thisisjava.ch19.sec06;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class CreateJsonExample {
    public static void main(String[] args) throws IOException {
        // JSON 객체 생성 -> 반드시 라이브러리 다운 받아서 적용해야
        JSONObject root = new JSONObject();

        // 속성 추가
        root.put("id", "winter");
        root.put("name", "겨울");
        root.put("age", 18);
        root.put("student", true);

        // 객체 속성 추가
        JSONObject tel = new JSONObject();
        tel.put("home", "02-123-1234");
        tel.put("mobile", "010-123-1234");
        root.put("tel", tel);

        // 배열 속성 추가
        JSONArray skill = new JSONArray();
        skill.put("java");
        skill.put("python");
        skill.put("javascript");
        root.put("skill", skill);

        // JSON 얻기
        String json = root.toString();

        System.out.println(json);

        // 파일로 저장
        Writer writer = new FileWriter("src/thisisjava/ch19/sec06/member.json", Charset.forName("UTF-8"));
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
