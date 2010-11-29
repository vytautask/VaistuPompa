<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<link REL="SHORTCUT ICON" HREF="http://www.vytautas.net/vaistupompa/favicon.ico">
<title>Vaistų pompa</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.twitter.js"></script>
<script type="text/javascript">
     $(document).ready(function(){
		$("#twitter").getTwitter({
			userName: "vaistupompa",
			numTweets: 5,
			loaderText: "Kraunami paskutiniai pakeitimai...",
			slideIn: true,
			slideDuration: 750,
			showHeading: true,
			headingText: "Paskutiniai pakeitimai",
			showProfileLink: false,
			showTimestamp: false
		});
     });
</script>
<style type="text/css">
body {
 background-color: #fff;
 margin: 40px;
 font-family: Lucida Grande, Verdana, Sans-serif;
 font-size: 14px;
 color: #4F5155;
}

a {
 color: #003399;
 background-color: transparent;
 font-weight: normal;
}

h1 {
 color: #444;
 background-color: transparent;
 border-bottom: 1px solid #D0D0D0;
 font-size: 16px;
 font-weight: bold;
 margin: 24px 0 2px 0;
 padding: 5px 0 6px 0;
}

code {
 font-family: Monaco, Verdana, Sans-serif;
 font-size: 12px;
 background-color: #f9f9f9;
 border: 1px solid #D0D0D0;
 color: #002166;
 display: block;
 margin: 14px 0 14px 0;
 padding: 12px 10px 12px 10px;
}

.twitted {
	width: 200px;
	margin-bottom: 1.5em;
	border: 1px solid #888;
}

.twitted h2 {
	margin: 0;
	padding: 0.3em 0.8em;
	font-size: 14px;
	color: #fff;
	background-color: #888;
}

.twitted p.preLoader {
	margin: 0;
	padding: 1em 1em 1em 3em;
	background: transparent url("loader.gif") 1em center no-repeat;
	/* generate your own loader gif: http://www.ajaxload.info */
}

.twitted ul#twitter_update_list {
	margin: 0;
	padding: 0 0.8em;
	list-style-type: none;
}

.twitted ul#twitter_update_list li {
	margin: 0;
	padding: 0.8em 0 1em 0;
	border-bottom: 1px solid #ccc;
}

.twitted ul#twitter_update_list li span {
	/* tweet content */
	display: block;
	font-size: 9px;
}

.twitted ul#twitter_update_list li span a {
	/* links in tweet content */
	color: #00f;
}

.twitted ul#twitter_update_list li a {
	/* timestamp link */
	color: #f00;
}

.twitted ul#twitter_update_list li.firstTweet {
}

.twitted ul#twitter_update_list li.lastTweet {
	border-bottom: none;
}

.twitted p.profileLink {
	display: block;
	margin: 0;
	padding: 0.3em 1em;
	color: #fff;
	background-color: #ddd;
}
</style>
</head>
<body>

<h1>Sveiki atvykę į vaistų pompos kursinio darbo puslapį!</h1>

<p>Konvencinio ir paskirstytos infuzijos paciento kontroliuojamos analgezijos virtualių modelių sukūrimas ir tyrimai</p>

<code><b>Darbą atlieka:</b><br/> 
Jonas Minelga<br/>
Vytautas Kasparavičius<br/>
Dainius Vaitiekus<br/>
Agnė Meilutytė<br/>
Gintarė Veličkaitė<br/>
Audrius Česna</code>

<div id="twitter">
	<p><a href="http://twitter.com/jquery">http://twitter.com/jquery</a></p>
</div>

<p><br />Puslapis sugeneruotas per {elapsed_time} sekundžių</p>

</body>
</html>