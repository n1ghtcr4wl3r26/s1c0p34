function fEvaluaModif() {
    var Mensaje = "";
    f = document.reginfForm;
    if (bCancel == true)
        return true;
    var fecha2 = new Date();
    var ano = fecha2.getFullYear();
    var mes = (fecha2.getMonth() < 9) ? ("0" + (fecha2.getMonth() + 1)) : (fecha2.getMonth() + 1);
    var dia = (fecha2.getDate() <= 9) ? ("0" + fecha2.getDate()) : (fecha2.getDate());
    var fActual = ano + "" + mes + "" + dia;

    f.vcite.value = fUpper(f.vcite.value);
    f.vnombre.value = fUpper(f.vnombre.value);
    f.vcargo.value = fUpper(f.vcargo.value);
    f.vobs.value = fUpper(f.vobs.value);
    if (f.ventidad.value == 0)
        Mensaje = Mensaje + 'Debe seleccionar una entidad\n';
    if (!fTrim(f.vcite.value))
        Mensaje = Mensaje + 'Debe introducir un n\372mero de CITE\n';
    if (!foFecha(f.vfeccite.value))
        Mensaje = Mensaje + 'Ingrese la fecha del CITE\n';
    else {
        var ffin = f.vfeccite.value.substring(6, 10) + f.vfeccite.value.substring(3, 5) + f.vfeccite.value.substring(0, 2);
        if (fActual < ffin) {
            Mensaje = Mensaje + "'Fecha de CITE' no puede ser superior a la fecha de Hoy\n";
        }
    }
    if (!fTrim(f.vnombre.value))
        Mensaje = Mensaje + 'Ingrese el nombre de la persona acreditada\n';
    if (!fTrim(f.vcargo.value)) {
        Mensaje = Mensaje + 'Ingrese el cargo de la persona acreditada\n';
    }
    else {
        if (f.vcargo.value.length > 300) {
            Mensaje = Mensaje + 'El cargo de la persona acreditada, no puede tener m\341s de 300 caracteres\n';
        }
    }
    if (!fTrim(f.vcategoria.value))
        Mensaje = Mensaje + 'Debe seleccionar la categor\355a de la persona acreditada\n';
    if (!fTrim(f.vobs.value))
        Mensaje = Mensaje + 'Debe colocar un CITE u observaci\363n del cambio realizado\n';
    if (!foFecha(f.vfecllegada.value))
        Mensaje = Mensaje + 'Ingrese la Fecha de llegada\n';
    else {
        ffin = f.vfecllegada.value.substring(6, 10) + f.vfecllegada.value.substring(3, 5) + f.vfecllegada.value.substring(0, 2);
        if (fActual < ffin) {
            Mensaje = Mensaje + "'Fecha de llegada' no puede ser superior a la fecha de Hoy\n";
        }
    }
    if (!foFecha(f.vfeccese.value))
        Mensaje = Mensaje + 'Ingrese la Fecha de cese\n';
    if (!foFecha(f.vfecobs.value)){
        Mensaje = Mensaje + 'Ingrese la Fecha de solicitud de la modificaci\363n\n';
    } else {
        ffin = f.vfecobs.value.substring(6, 10) + f.vfecobs.value.substring(3, 5) + f.vfecobs.value.substring(0, 2);
        if (fActual < ffin) {
            Mensaje = Mensaje + "'Fecha de solicitud' no puede ser superior a la fecha de Hoy\n";
        }
    }

    if (!fcFechas(f.vfeccese.value, f.vfecllegada.value))
        Mensaje = Mensaje + 'La fecha de cese debe ser mayor a la de llegada\n';

    if (Mensaje == "")
        return confirm("Est\341 seguro de grabar las modificaciones realizadas.");
    else {
        alert(Mensaje);
        return false;
    }
}

function fEvaluaModif2() {
    var Mensaje = "";
    f = document.reginfForm;
    if (bCancel == true)
        return true;
    var fecha2 = new Date();
    var ano = fecha2.getFullYear();
    var mes = (fecha2.getMonth() < 9) ? ("0" + (fecha2.getMonth() + 1)) : (fecha2.getMonth() + 1);
    var dia = (fecha2.getDate() <= 9) ? ("0" + fecha2.getDate()) : (fecha2.getDate());
    var fActual = ano + "" + mes + "" + dia;

    f.vcite.value = fUpper(f.vcite.value);
    f.vnombre.value = fUpper(f.vnombre.value);
    f.vcargo.value = fUpper(f.vcargo.value);
    f.vobs.value = fUpper(f.vobs.value);
    if (f.ventidad.value == 0)
        Mensaje = Mensaje + 'Debe seleccionar una entidad\n';
    if (!fTrim(f.vcite.value))
        Mensaje = Mensaje + 'Debe introducir un n\372mero de CITE\n';
    if (!foFecha(f.vfeccite.value))
        Mensaje = Mensaje + 'Ingrese la fecha del CITE\n';
    else {
        var ffin = f.vfeccite.value.substring(6, 10) + f.vfeccite.value.substring(3, 5) + f.vfeccite.value.substring(0, 2);
        if (fActual < ffin) {
            Mensaje = Mensaje + "'Fecha de CITE' no puede ser superior a la fecha de Hoy\n";
        }
    }
    if (!fTrim(f.vnombre.value))
        Mensaje = Mensaje + 'Ingrese el nombre de la persona acreditada\n';
    if (!fTrim(f.vcargo.value)) {
        Mensaje = Mensaje + 'Ingrese el cargo de la persona acreditada\n';
    }
    else {
        if (f.vcargo.value.length > 300) {
            Mensaje = Mensaje + 'El cargo de la persona acreditada, no puede tener m\341s de 300 caracteres\n';
        }
    }
    if (!fTrim(f.vcategoria.value))
        Mensaje = Mensaje + 'Debe seleccionar la categor\355a de la persona acreditada\n';
    if (!fTrim(f.vobs.value))
        Mensaje = Mensaje + 'Debe colocar un CITE u observaci\363n del cambio realizado\n';
    if (!foFecha(f.vfecllegada.value))
        Mensaje = Mensaje + 'Ingrese la Fecha de llegada\n';
    else {
        ffin = f.vfecllegada.value.substring(6, 10) + f.vfecllegada.value.substring(3, 5) + f.vfecllegada.value.substring(0, 2);
        if (fActual < ffin) {
            Mensaje = Mensaje + "'Fecha de llegada' no puede ser superior a la fecha de Hoy\n";
        }
    }

    if (!foFecha(f.vfecobs.value)){
        Mensaje = Mensaje + 'Ingrese la Fecha de solicitud de la modificaci\363n\n';
    } else {
        ffin = f.vfecobs.value.substring(6, 10) + f.vfecobs.value.substring(3, 5) + f.vfecobs.value.substring(0, 2);
        if (fActual < ffin) {
            Mensaje = Mensaje + "'Fecha de solicitud' no puede ser superior a la fecha de Hoy\n";
        }
    }

    if (Mensaje == "")
        return confirm("Est\341 seguro de grabar las modificaciones realizadas.");
    else {
        alert(Mensaje);
        return false;
    }
}