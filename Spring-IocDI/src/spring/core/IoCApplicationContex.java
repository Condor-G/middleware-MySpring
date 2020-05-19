package spring.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
 
public class IoCApplicationContex {
 
	private Map<String, Object> beans = new HashMap<String,Object>();
	
	public IoCApplicationContex(String file) throws Exception{
		
		SAXBuilder sb = new SAXBuilder();//�½�xml������
		Document xmlDoc = sb.build(this.getClass().getClassLoader().getResourceAsStream(file));//�����ĵ�����
		Element root = xmlDoc.getRootElement();//��ȡ��Ԫ��
		List<Element> list = root.getChildren("bean");//��ȡ��Ԫ������������Ϊbean��Ԫ��
		
		//�������е�beanԪ�أ����������beans��
		for(int i = 0;i<list.size();i++){
			Element e = (Element)list.get(i);//��ȡElementԪ��
			String id = e.getAttributeValue("id");//��ȡproperty��id���Ե�ֵ
			String clazz = e.getAttributeValue("class");//��ȡproperty��class���Ե�ֵ
			Object o = Class.forName(clazz).newInstance();//���÷�������һ�������ʵ��
			//System.out.println(" id: "+id+" class: "+clazz);
			beans.put(id, o);//��bean����һ��HashMap
			//����bean�µ�����properyt���ԣ�������setter��������ֵע�����Ӧ������
			if(e.getChild("property")!=null){
				for(Element p : (List<Element>)e.getChildren("property")){
					String name = p.getAttributeValue("name");
					String bean = p.getAttributeValue("ref"); //�������� inf
					String value = p.getAttributeValue("value"); //������ value
					
					if(bean!=null) {
						//System.out.println(name+" :ref "+bean);
						Object beanObject = beans.get(bean);
						String methodName = "set" + name.substring(0,1).toUpperCase()+ name.substring(1);
						//System.out.println("setter method name = " +methodName);
						Method m = o.getClass().getMethod(methodName,beanObject.getClass().getInterfaces()[0]);
						m.invoke(o,beanObject);//����setter����
					}
					if(value!=null) {
						//System.out.println(name+" :val "+value);
						String methodName = "set" + name.substring(0,1).toUpperCase()+ name.substring(1);
						//System.out.println("setter method name = " +methodName);
						Method m = o.getClass().getMethod(methodName,String.class);
						m.invoke(o,value);//����setter����
					}
				}
			}	
		}		
	}
	
	public Object getBean(String id) {
		return beans.get(id);
	}
 
}
