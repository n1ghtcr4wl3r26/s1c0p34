select d.ser_nber,d.me1_cod,d.ser_marca,d.ser_modelo,d.ser_serie,d.ser_obs from ser_cabser c,ser_detser d
where c.key_year=2009 and c.key_cuo=201 and c.sad_reg_serial='C' and c.sad_reg_nber=5257
and c.ser_id=d.ser_id and d.itm_nber=3 and d.lst_ope='U' and d.ser_num=0

