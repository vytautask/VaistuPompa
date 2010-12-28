﻿<?php 
	$this->load->view('header');
?>
<script type="text/javascript" src="js/jquery.twitter.js"></script>
<script type="text/javascript">
     $(document).ready(function(){
		$("#twitter").getTwitter({
			userName: "vaistupompa",
			numTweets: 3,
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
<?php
	$this->load->view('menu');
?>
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

	<p>Visos sistemos išeities tekstą galima pasiekti per github.com: <a href="https://github.com/vytautask/VaistuPompa">https://github.com/vytautask/VaistuPompa</a>. <br/>Taip pat išeities tekstus galima parsisiųsti iš <a href="VaistuPompa-a5f2e42.zip">čia</a>.</p>
	
	<div id="twitter">
		<p><a href="http://twitter.com/jquery"></a></p>
	</div>
</div>
<?php
	$this->load->view('footer');
?>
