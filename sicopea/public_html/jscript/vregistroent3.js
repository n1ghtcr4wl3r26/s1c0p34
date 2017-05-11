function fEvalua( )
{
  var Mensaje = "";
  f = document.reginfForm;
  if( bCancel == true ) return true;

  f.vcite.value = fUpper( f.vcite.value );
  f.vnombre.value = fUpper( f.vnombre.value );
  f.vcargo.value = fUpper( f.vcargo.value );
  if( f.ventidad.value == 0)
    Mensaje = Mensaje + 'Debe seleccionar una entidad\n';
  if( ! fTrim( f.vcite.value ) )
    Mensaje = Mensaje + 'Debe introducir un n\372mero de CITE\n';
  if( ! foFecha( f.vfeccite.value ) )
    Mensaje = Mensaje + 'Ingrese la fecha del CITE\n';
  if( ! fTrim( f.vnombre.value ) )
    Mensaje = Mensaje + 'Ingrese el nombre de la persona acreditada\n';
  if( ! fTrim( f.vcargo.value ) ){
    Mensaje = Mensaje + 'Ingrese el cargo de la persona acreditada\n';
  } else {
    if( f.vcargo.value.length > 300 ){
    Mensaje = Mensaje + 'El cargo de la persona acreditada, no puede tener m\341s de 300 caracteres\n';
    }  
  }
  if( ! fTrim( f.vcategoria.value ) )
    Mensaje = Mensaje + 'Debe seleccionar la categor\355a de la persona acreditada\n';
  if( ! foFecha( f.vfecllegada.value ) )
    Mensaje = Mensaje + 'Ingrese la Fecha de llegada\n';
  if( ! foFecha( f.vfeccese.value ) )
    Mensaje = Mensaje + 'Ingrese la Fecha de cese\n';
  if( ! fcFechas( f.vfeccese.value, f.vfecllegada.value))
    Mensaje = Mensaje + 'La fecha de cese debe ser mayor a la de llegada\n';

  if( Mensaje == "" )
    return confirm("Est\341 seguro de realizar el registro de la persona acreditada.");
  else
  {
    alert( Mensaje );
    return false;
  }
}

function fEvalua2( )
{
  var Mensaje = "";
  f = document.reginfForm;
  if( bCancel == true ) return true;

  
  if( f.vtipodoc.value == "")
    Mensaje = Mensaje + 'Debe seleccionar una clase de Pasaporte\n';
  if( ! fTrim( f.vdocidentidad.value ) )
    Mensaje = Mensaje + 'Debe introducir un n\372mero de Pasaporte\n';
  

  if( Mensaje == "" )
    return true;
  else
  {
    alert( Mensaje );
    return false;
  }
}
