package Classes; /**
 * Created by Danila on 30.10.2017.
 */
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReaderLoopDemo {
    static ArrayList<DayVal> dayvals = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i <dayvals.size() ; i++) {
            System.out.println(dayvals.get(i).val+" "+dayvals.get(i).getNameVal());
        }
    }

    public ArrayList<DayVal> xmlReader() {

        try {

            File file = new File("currency.xml");

            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();

            Document doc = dBuilder.parse(file);

          //  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            if (doc.hasChildNodes()) {

                printNote(doc.getChildNodes());

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dayvals;
    }


    private static ArrayList<DayVal> printNote(NodeList nodeList) {
        //трехбуквенные хранятся в node.getNodeValue()
        //обычные хранятся в tempNode.getTextContent()

        for (int count = 0; count < nodeList.getLength(); count++) {

            Node tempNode = nodeList.item(count);

            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {


                System.out.println("Node Value =" + tempNode.getTextContent());

                if (tempNode.hasAttributes()) {
                    NamedNodeMap nodeMap = tempNode.getAttributes();


                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);

                 /*    System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());*/
                 if(node.getNodeName().equals("VALUE")){
                        DayVal dv = new DayVal(node.getNodeValue(), null, 0, 0 );
                        dv.setNameVal(tempNode.getTextContent());
                        dayvals.add(dv);
                    }
                    }

                }

               if (tempNode.hasChildNodes()) {

                    // loop again if has child nodes
                    printNote(tempNode.getChildNodes());

                }

            }

        }
        return dayvals;

    }

}
