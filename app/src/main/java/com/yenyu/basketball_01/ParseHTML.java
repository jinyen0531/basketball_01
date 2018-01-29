package com.yenyu.basketball_01;


import com.yenyu.basketball_01.dao.Game;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Student on 2018/1/23.
 */

public class ParseHTML {

    public String getString(ArrayList<Game> mylist)
    {
        DocumentBuilderFactory df=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder= null;
        Document doc=null;
        try {
            builder = df.newDocumentBuilder();
            doc=builder.newDocument();

            Element html=doc.createElement("html");
            Element body=doc.createElement("body");
            Element table=doc.createElement("table");
            table.setAttribute("border","1");

            //建立表頭
            Element tr=doc.createElement("tr");
//            Element th=doc.createElement("th");
//            th.setAttribute("rowspan","2");
//            th.appendChild(doc.createTextNode("埸次"));
//            tr.appendChild(th);

            Element th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode("節次"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode("背號"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode("分數"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("colspan","2");
            th.appendChild(doc.createTextNode("二分"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("colspan","2");
            th.appendChild(doc.createTextNode("三分"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("colspan","2");
            th.appendChild(doc.createTextNode("罰球"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("colspan","2");
            th.appendChild(doc.createTextNode("籃板"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode("抄截"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode("助攻"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode("阻攻"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode("失誤"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode("犯規"));
            tr.appendChild(th);
            table.appendChild(tr);

            tr=doc.createElement("tr");
            th=doc.createElement("th");
            th.appendChild(doc.createTextNode("進"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode("不進"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode("進"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode("不進"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode("進"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode("不進"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode("進攻"));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode("防守"));
            tr.appendChild(th);
            table.appendChild(tr);

            //填入內容
            Element td=null;
            for(int i=0;i<mylist.size();i++)
            {
                tr=doc.createElement("tr");
//                td=doc.createElement("td");
//                td.setAttribute("align","center");
//                td.appendChild(doc.createTextNode(mylist.get(i).getPid()));
//                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getSection())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(mylist.get(i).getNumber()));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getScore())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getPoint2in())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getPoint2out())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getPoint3in())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getPoint3out())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getFtin())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getFtout())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getOr())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getDr())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getSt())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getAs())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getBs())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getTo())));
                tr.appendChild(td);

                td=doc.createElement("td");
                td.setAttribute("align","center");
                td.appendChild(doc.createTextNode(String.valueOf(mylist.get(i).getFoul())));
                tr.appendChild(td);

                table.appendChild(tr);
            }

            body.appendChild(table);
            html.appendChild(body);
            doc.appendChild(html);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return parse(doc);
    }

    private String parse(Document document)
    {
        DOMSource domSource=new DOMSource(document);
        StringWriter writer=new StringWriter();
        StreamResult result=new StreamResult(writer);

        TransformerFactory ft=TransformerFactory.newInstance();
        Transformer transformer= null;
        try {
            transformer = ft.newTransformer();
            transformer.transform(domSource,result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return writer.toString();
    }
}
