<?php

class Constants_model extends Model 
{
	var $painConst = 15.45;
	
	function Constants_model()
	{
		parent::Model();
	}
	
	function getPaintConst()
	{
		return $this->painConst;
	}
}