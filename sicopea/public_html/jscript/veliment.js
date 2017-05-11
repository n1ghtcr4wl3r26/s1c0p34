function fEvalua( )
{
  var Mensaje = "";
  
  if( Mensaje == "" )
    return confirm("Esta seguro de eliminar a esta Entidades.");
  else
  {
    alert( Mensaje );
    return false;
  }
}