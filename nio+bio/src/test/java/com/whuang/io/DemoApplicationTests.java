package com.whuang.io;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class DemoApplicationTests {




    @Test
    void contextLoads() {
        "sdf".length();
    }

    @Test
    public void TestReadXml3() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    }
    @Test
    public void TestReadXml() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("src/main/resources/language.xml"));
            NodeList sList = document.getElementsByTagName("student");
            Element element = (Element) sList.item(0);
            NodeList childNodes = element.getChildNodes().item(0).getChildNodes();
            String textContent = element.getChildNodes().item(0).getNextSibling().getFirstChild().getTextContent();
            System.out.println(textContent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void asaset() throws FileNotFoundException {
        File file = new File("src/main/resources/application.yaml");
        FileInputStream fileInputStream = new FileInputStream(file);
    }


}
