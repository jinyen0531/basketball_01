package com.yenyu.basketball_01;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.yenyu.basketball_01.dao.Action;
import com.yenyu.basketball_01.dao.Game;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Locale;

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

    Resources res;
    public ParseHTML(Context context)
    {
        res=context.getResources();
    }

    public String getString(ArrayList<Game> mylist)
    {
        if(mylist.size() ==0 || mylist==null) return "<html><body bgcolor='#FDF5E6'>"+res.getString(R.string.nodata)+"</body></thml>";
        DocumentBuilderFactory df=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder= null;
        Document doc=null;
        try {
            builder = df.newDocumentBuilder();
            doc=builder.newDocument();

            Element html=doc.createElement("html");
            Element body=doc.createElement("body");
            body.setAttribute("bgcolor","#FDF5E6");
            Element table=doc.createElement("table");
            table.setAttribute("border","1");

            //建立表頭
            Element tr=doc.createElement("tr");

            Element th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.section)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.number)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.score)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("colspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.point2)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("colspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.point3)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("colspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.ft)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("colspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.rebound)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.ST)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.AS)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.BS)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.TO)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.setAttribute("rowspan","2");
            th.appendChild(doc.createTextNode(res.getString(R.string.foul)));
            tr.appendChild(th);
            table.appendChild(tr);

            tr=doc.createElement("tr");
            th=doc.createElement("th");
            th.appendChild(doc.createTextNode(res.getString(R.string.goal)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode(res.getString(R.string.miss)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode(res.getString(R.string.goal)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode(res.getString(R.string.miss)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode(res.getString(R.string.goal)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode(res.getString(R.string.miss)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode(res.getString(R.string.oror)));
            tr.appendChild(th);

            th=doc.createElement("th");
            th.appendChild(doc.createTextNode(res.getString(R.string.drdr)));
            tr.appendChild(th);
            table.appendChild(tr);

            //填入內容
            Element td=null;
            for(int i=0;i<mylist.size();i++)
            {
                tr=doc.createElement("tr");

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

    //將Document轉為字串
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

    //將actions轉換為games
    public ArrayList<Game> getSummary(ArrayList<Action> actions)
    {
        String pid=DataActivity.pid;
        ArrayList<Game> games=new ArrayList<>();
        //先指定第一筆資料
        int section=actions.get(0).getSection();
        String number=actions.get(0).getNumber();
        int count=0;
        games.add(new Game(pid,section,number));

        for(int i=0;i<actions.size();i++) {
            Log.d("action",actions.get(i).toString());
            if (section != actions.get(i).getSection() || !actions.get(i).getNumber().equals(number)) {
                section = actions.get(i).getSection();
                number = actions.get(i).getNumber();
                games.add(new Game(pid, section, number));
                count++;
            }
            switch (actions.get(i).getMove()) {
                case RecordAction.Action_2point_in:
                    games.get(count).setPoint2in(games.get(count).getPoint2in() + 1);
                    games.get(count).setScore(games.get(count).getScore() + 2);
                    break;
                case RecordAction.Action_2point_out:
                    games.get(count).setPoint2out(games.get(count).getPoint2out() + 1);
                    break;
                case RecordAction.Action_3point_in:
                    games.get(count).setPoint3in(games.get(count).getPoint3in() + 1);
                    games.get(count).setScore(games.get(count).getScore() + 3);
                    break;
                case RecordAction.Action_3point_out:
                    games.get(count).setPoint3out(games.get(count).getPoint3out() + 1);
                    break;
                case RecordAction.Action_FT_in:
                    games.get(count).setFtin(games.get(count).getFtin() + 1);
                    games.get(count).setScore(games.get(count).getScore() + 1);
                    break;
                case RecordAction.Action_FT_out:
                    games.get(count).setFtout(games.get(count).getFtout() + 1);
                    break;
                case RecordAction.Action_OR:
                    games.get(count).setOr(games.get(count).getOr() + 1);
                    break;
                case RecordAction.Action_DR:
                    games.get(count).setDr(games.get(count).getDr() + 1);
                    break;
                case RecordAction.Action_ST:
                    games.get(count).setSt(games.get(count).getSt() + 1);
                    break;
                case RecordAction.Action_AS:
                    games.get(count).setAs(games.get(count).getAs() + 1);
                    break;
                case RecordAction.Action_BS:
                    games.get(count).setBs(games.get(count).getBs() + 1);
                    break;
                case RecordAction.Action_TO:
                    games.get(count).setTo(games.get(count).getTo() + 1);
                    break;
                case RecordAction.Action_Foul:
                    games.get(count).setFoul(games.get(count).getFoul() + 1);
                    break;
            }
        }
        return games;
    }
}
