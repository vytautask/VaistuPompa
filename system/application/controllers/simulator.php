<?php

class Simulator extends Controller {

	function Simulator()
	{
		parent::Controller();	
	}
	
	function index()
	{
		$this->load->view('simulator');
	}
}