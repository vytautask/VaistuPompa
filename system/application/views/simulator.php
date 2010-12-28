<?php
	$this->load->view('header');
?>
<script type="text/javascript">
     $(document).ready(function(){
		
     });
</script>
</head>
<body>
<?php
	$this->load->view('menu');
?>
<div id="content">
	<h1>Vaistų pompos simuliacija</h1>
        <APPLET ALIGN="CENTER" CODE="vaistupompa/MainForm.class" archive="applet/VaistuPompa/dist/VaistuPompa.jar, applet/VaistuPompa/dist/lib/groovylab.jar, applet/VaistuPompa/dist/lib/jmatharray.jar, applet/VaistuPompa/dist/lib/jmathio.jar" 
		WIDTH="800" HEIGHT="770">
	</APPLET
</div>