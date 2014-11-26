import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroovyPatten{
	

    public void testPattenGroovy(){
    	println "testPatten use groovy code"
    	def twoDot = ~/\.\d{2}/
    	// or
       	"122.55MB".replaceAll(/\.\d{2}/) { match ->
       		println match
        }

    }

    public void testPattenJava(){
    	println "use java code"
    	String formatText = "102.45MB"
       	Pattern twoDot = Pattern.compile("\\.\\d{2}");
       	final Matcher matcher = twoDot.matcher(formatText);
       	if(matcher.find()){
       		formatText = matcher.replaceAll("...");
       	}
       	println formatText;
    }

    void testHtml(){
        def result = "afdsfas<dsfa>f<html><head>asdf</html>dfadsa" =~ /<html>.*<\/html>/
        println result[0]
    }

}

new GroovyPatten().testHtml()