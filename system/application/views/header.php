﻿<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<link REL="SHORTCUT ICON" HREF="http://www.vytautas.net/vaistupompa/favicon.ico">
<link rel=StyleSheet href="styles/style.css" type="text/css" media=screen>
<link type="text/css" href="styles/jquery-ui-1.8.6.custom.css" rel="Stylesheet" />	
<script src="https://www.google.com/jsapi?key=ABQIAAAALJUDalRtNpcPKa_eqI4baBQL9ggXnREq0tF4QFiPZCpS2XbXThSmuEHcHAE_ftg9A2k7sNt--pm_vw" type="text/javascript"></script>
    <script language="Javascript" type="text/javascript">
    //<![CDATA[
    google.load("jquery", "1.4.4");
	google.load("jqueryui", "1.8.7");
    //]]>
    </script>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script> -->
<!-- <script src="js/jquery-ui-1.8.6.custom.min.js" type="text/javascript"></script> -->
<script type="text/javascript">
     $(document).ready(function(){
		$("input:button").button();
     });
	 
	 function loadPageFromMenu(page)
	 {
		$("div#content").html('<center><img src="images/loader.gif" style="margin-top: 50px"/></center>');
		$("div#content").load(page +" div#content");
		$("div#content").hide();
		$("div#content").fadeIn("slow");
		
		return false;
	 }
</script>
