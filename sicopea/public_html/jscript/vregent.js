function fEvalua( )
{
  var Mensaje = "";
  f = document.regentForm;
  if( bCancel == true ) return true;

  f.vnombre.value = fUpper( f.vnombre.value );
  f.vdireccion.value = fUpper( f.vdireccion.value );
  f.vmail.value = fUpper( f.vmail.value );
  
  if( ! fTrim( f.vnombre.value ) )
    Mensaje = Mensaje + 'Debe introducir el nombre de la Instituci\363n\n';
  if( ! fTrim( f.vdireccion.value ) )
    Mensaje = Mensaje + 'Debe introducir la direcci\363n de la Instituci\363n\n';
  if( ! fTrim( f.vtel.value ) )
    Mensaje = Mensaje + 'Debe introducir el n\372mero de telefono de la Instituci\363n\n';
  if( ! fTrim( f.vfax.value ) )
    Mensaje = Mensaje + 'Debe introducir el n\372mero de fax de la Instituci\363n\n';
  if( ! fTrim( f.vmail.value ) )
    Mensaje = Mensaje + 'Debe introducir la direcci\363n de correo electr\363nico o el de la p\341gina web de la Instituci\363n\n';
  

  if( Mensaje == "" )
    return confirm("Est\341 seguro de realizar el registro de esta Instituci\363n.");
  else
  {
    alert( Mensaje );
    return false;
  }
}