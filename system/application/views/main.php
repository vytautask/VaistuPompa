﻿<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<html>
<head>
<link REL="SHORTCUT ICON" HREF="http://www.vytautas.net/vaistupompa/favicon.ico">
<link rel=StyleSheet href="styles/style.css" type="text/css" media=screen>
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
</head>
<body>
<div id="meniu">
	<div id="submeniu">
		<a href="index.php">Pagrindinis</a>
		<span>|</span>
		<a href="index.php?simulator">Simuliacija</a>
		<span>|</span>
		<a href="index.php?parameters">Parametrai</a>
	</div>
</div>
<div id="content">
	<h1>Sveiki atvykę į vaistų pompos kursinio darbo puslapį!</h1>

	<p>Konvencinio ir paskirstytos infuzijos paciento kontroliuojamos analgezijos virtualių modelių sukūrimas ir tyrimai</p>

	<code><b>Darbą atlieka:</b><br/> 
	Jonas Minelga<br/>
	Vytautas Kasparavičius<br/>
	Šarūnas Gliebus</br>
	Dainius Vaitiekus<br/>
	Agnė Meilutytė<br/>
	Gintarė Veličkaitė<br/>
	Audrius Česna</code>

	<div id="twitter">
		<p><a href="http://twitter.com/jquery">http://twitter.com/jquery</a></p>
	</div>

	<p><br />Puslapis sugeneruotas per {elapsed_time} sekundžių</p>
</div>
</body>
</html>