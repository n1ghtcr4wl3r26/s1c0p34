function fEvalua( )
{
  var Mensaje = "";
  f = document.forms[0];

  if( bCancel == true )
    return true;

  f.usuario.value = fUpper( f.usuario.value );

  if( ! fTrim( f.usuario.value ) )
    Mensaje = Mensaje + "'Usuario' es obligatorio\n";
  if( ! fTrim( f.clave.value ) )
    Mensaje = Mensaje + "'Anterior Contrase�a' es obligatorio\n";
  if( ! fTrim( f.nuevo.value ) )
    Mensaje = Mensaje + "'Nueva Contrase�a' es obligatorio\n";
  if( ! fTrim( f.confnuevo.value ) )
    Mensaje = Mensaje + "'Confirmaci�n Contrase�a' es obligatorio\n";
  if( f.nuevo.value != f.confnuevo.value )
    Mensaje = Mensaje + "'Nueva Contrase�a' y 'Confirmaci�n Contrase�a' no son iguales\n";

  if( Mensaje == "" )
    return confirm('Esta seguro de continuar!!!!');
  else
  {
    Mensaje = Mensaje + "\n... corrija los anteriores errores para continuar";
    alert( Mensaje );
    return false;
  }
}
