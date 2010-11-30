<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<link REL="SHORTCUT ICON" HREF="http://www.vytautas.net/vaistupompa/favicon.ico">
<link rel=StyleSheet href="styles/style.css" type="text/css" media=screen>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
     $(document).ready(function(){
		
     });
	 
	 function loadPageFromMenu(page)
	 {
		$("div#content").html('<img src="images/loader.gif/>"');
		$("div#content").load(page +" div#content");
		$("div#content").hide();
		$("div#content").fadeIn("slow");
		
		return false;
	 }
</script>
