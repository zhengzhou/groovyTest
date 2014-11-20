@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1' )
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
@Grab(group="org.jsoup",module="jsoup",version="1.8.1")
import org.jsoup.Jsoup

def domain = 'http://www.qjvpn.net'
def http = new HTTPBuilder(domain)
http.request( POST , TEXT ){
	uri.path='/user/checklogin.php'

	headers.'Accept' = 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8'
	//headers.'Accept-Encoding' = 'gzip, deflate'
	headers.'Accept-Language' = 'en-US,en;q=0.5'
	headers.'User-Agent' = 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:33.0) Gecko/20100101 Firefox/33.0'
	headers.'Content-Type' = 'application/x-www-form-urlencoded'
	headers.'Cookie' = 'PHPSESSID=lrnu0snl151rrg5lcj4qb0r842; IESESSION=alive; Hm_lvt_7daca9d99dad7889e272ffe1913d0407=1416450523; Hm_lpvt_7daca9d99dad7889e272ffe1913d0407=1416450523; pgv_pvi=9240707072; pgv_si=s8323674112'
	headers.'Referer' = 'http://www.qjvpn.net/user/login.php'
	headers.'Connection' = 'keep-alive'
	//huahuasa
	body =  [username:'huahuasa',password:'huahuasa',from:'']

	response.success = { resp,html ->
    	println "${html}"
    	assert resp.status < 400
  	}
 
  	response.failure = { resp ->
    	println "request failed ${resp.statusLine}"
    	assert resp.status >= 400
  	}
}
    
http.get( path : '/user/center.php', contentType : TEXT ) { resp, reader ->	
    println reader.read()
}


//span.btn
//def file = Jsoup.connect("${domain}/user/center.php").get().select('body');

