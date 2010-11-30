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
	<?php
		$this->load->helper('form');
		
		echo form_open("simulator/simulate");
		
		$data = array(
			'name' => 'lambda',
			'id' => 'lambda',
			'value' => '15',
			'maxlength' => "3",
			'style' => 'width: 30px',
		);
		
		echo form_label('Vidutinis vaisto pareikalavimų skaičius per valandą:', 'lambda');
		echo form_input($data);
		
		echo '<br />';
		
		echo form_label('Vaistų išdavimo laiko limitas (sekundėmis):', 't');
		$data = array(
			'name' => 't',
			'id' => 't',
			'value' => '20',
			'maxlength' => "10",
			'style' => 'width: 50px',
		);
		echo form_input($data);
		
		echo '<br />';
		
		echo form_label('delta t ([PKA] - kuriam laikui pompa blokuojama po vaistų išskyrimo, [iPKA] - per kiek laiko vaistas įšvirkščiamas, sekundėmis):', 'delta_t');
		$data = array(
			'name' => 'delta_t',
			'id' => 'delta_t',
			'value' => '20',
			'maxlength' => "10",
			'style' => 'width: 50px',
		);
		echo form_input($data);
		
		echo '<br />';
		
		echo form_label('delta t ([PKA] - kuriam laikui pompa blokuojama po vaistų išskyrimo, [iPKA] - per kiek laiko vaistas įšvirkščiamas', 'delta_t');
		$data = array(
			'name' => 'delta_t',
			'id' => 'delta_t',
			'value' => '20',
			'maxlength' => "10",
			'style' => 'width: 50px',
		);
		echo form_input($data);
		
		echo form_close();
	?>
	<div id="dialog" title="Basic dialog" style="display: none">
		<p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the 'x' icon.</p>
	</div>
	<input type="button" onClick="$('#dialog').dialog(); return false;" name="simulate" value="Simuliuoti"/>
</div>
<?php
	$this->load->view('footer');
?>