<?php

class Generator_model extends Model 
{
	function Generator_model()
	{
		parent::Model();
	}
	
	/**
	* Returns t(i)
	*/
	function generate($x1 = 0.0, $x2 = 0.0, $x3 = 0.0)
	{
		$this->load->model('Constants_model', 'constants');
		$painConst = $this->constants->getPainConst();
		
		$minVal = min($x1, $x2, $x3);
		if ($painConst >= $minVal)
		{
			$e = rand(0, 1000)/1000;
			
			return floatval((1/$lambda)*log($e));
		}
		else 
		{
			return PHP_INT_SIZE;
		}
	}
}
