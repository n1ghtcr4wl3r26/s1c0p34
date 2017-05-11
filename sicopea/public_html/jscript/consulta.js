$(document).ready(function() {
  $('form :radio[@name="tag"]').click(function() {
		if ($(this).val() == 'N') {
			$('#decla').show();
			$('#otro').hide();
		} else {
			$('#decla').hide();
			$('#otro').show();
		}
	});

	$('#search').bind('click', function() {
	  var o = $('form :radio:checked').val();
	  if (o=='N') {
  		var msg = '';
  		var o = /20\d{2}/.test($("#ano").val());
    	if (!o) msg = msg + '\n - Año de registro es incorrecto.';
      var o = /\d{3}/.test($("#aduana").val());
      if (!o) msg = msg + '\n - Código de aduana es incorrecto.';
      var o = /^[1-9]\d{0,9}$/.test($("#numero").val());
      if (!o) msg = msg + '\n - Número de registro es incorrecto.';
      if (msg) {alert('Detalle de errores: \n' + msg); return false;}
      else $("#frmcons").submit(); 
		}	else {
      $("#frmcons").submit(); 
    }
	});
	$('table.lista tr').bind('click', function(){
		var o = $(this).children('th:first').text();
		var p = $(this).children('td:nth-child(3)').text();
		var q = $(this).children('td:nth-child(2)').text();
		$('#citem').val(o.substring(0));
		$('#cdav').val(p.substring(0));
		$('#cdui').val(q.substring(0));
		$('#consulta').submit()
	});
	$('table.lista tr:even').addClass('alt');
	$('table.lista tbody tr').mouseover(function(){
		$(this).addClass('over');
	});
	$('table.lista tr').mouseout(function(){
		$(this).removeClass('over');
	});
	$('#mercaderia').bind('change', function(){
	  var op = '<option value="">-----</option>';
			$.getJSON("json.do",{parameter: 'marcas', p_merca: $(this).val()}, function(j){
				for (var i = 0; i < j.length; i++) {
					op += '<option value="' + j[i].value + '">' + j[i].label + '</option>';
				}
				$("#marca").html(op);        
			});
	});
	$('#marca').bind('change', function(){
	  var op = '';
			$.getJSON("json.do",{parameter: 'modelo', p_merca: $('#mercaderia').val(), p_marca: $(this).val()}, function(j){
				for (var i = 0; i < j.length; i++) {
					op += '<option value="' + j[i].value + '">' + j[i].label + '</option>';
				}
				$("#modelo").html(op);        
			});
	});  
	if($('form :radio:checked').val() == 'A') $('form :radio:checked').click();
	else $('form :radio[@value="N"]').click();	
});