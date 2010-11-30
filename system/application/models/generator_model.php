<?php

class Generator_model extends Model 
{
	var $x1;
	var $x2;
	var $x3;
	
	function Generator_model($x1 = 0.0, $x2 = 0.0, $x3 = 0.0)
	{
		parent::Model();
		
		$this->x1 = $x1;
		$this->x2 = $x2;
		$this->x3 = $x3;
	}
	
	function getX1()
	{
		return $this->x1;
	}
	
	function getX2()
	{
		return $this->x2;
	}
	
	function getX3()
	{
		return $this->x3;
	}
	
	/**
	* Returns generated epsilon or infinity.
	*/
	function generate()
	{
		$this->load->model('Constants_model', 'constants');
		$painConst = $this->constants->getPainConst();
		
		$minVal = min($this->x1, $this->x2, $this->x3);
		if ($painConst >= $minVal)
		{
			return floatval(((0, 1000)/1000));
		}
		else 
		{
			return PHP_INT_SIZE;
		}
	}
}
