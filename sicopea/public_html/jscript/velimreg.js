function fEvalua( )
{
  var Mensaje = "";
  
  if( Mensaje == "" )
    return confirm("Esta seguro de eliminar a este funcionario.");
  else
  {
    alert( Mensaje );
    return false;
  }
}