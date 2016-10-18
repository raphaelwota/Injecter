package br.com.injecter.core;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Injecter<T> {

    public T injectFrom(Class clss, JSONObject obj) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException, ClassNotFoundException {
        Class<T> classe = (Class<T>) clss;
        try {
            T retorno = classe.newInstance();

            for (Field field : classe.getFields()) {

                switch (field.getType().getName().toLowerCase()) {
                    case "java.lang.string":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getString(field.getName()));
                        break;
                    case "int":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getInt(field.getName()));
                        break;
                    case "integer":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getInt(field.getName()));
                        break;
                    case "double":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getDouble(field.getName()));
                        break;
                    case "boolean":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getBoolean(field.getName()));
                        break;
                    default:
                        Class c = Class.forName(field.getType().getName());
                        retorno.getClass().getField(field.getName()).set(retorno, injetarValor(c, obj.getJSONObject(field.getName())));
                        break;
                }
            }
            return retorno;
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | JSONException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    public List<T> injectFrom(Class clss, JSONArray array) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException, ClassNotFoundException {
        Class<T> classe = (Class<T>) clss;
        try {
            List<T> retorno = new ArrayList<T>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);
                T aux = (T) clss.newInstance();
                for (Field field : classe.getFields()) {
                    switch (field.getType().getName().toLowerCase()) {
                        case "java.lang.string":
                            aux.getClass().getField(field.getName()).set(aux, obj.getString(field.getName()));
                            break;
                        case "int":
                            aux.getClass().getField(field.getName()).set(aux, obj.getInt(field.getName()));
                            break;
                        case "integer":
                            aux.getClass().getField(field.getName()).set(aux, obj.getInt(field.getName()));
                            break;
                        case "double":
                            aux.getClass().getField(field.getName()).set(aux, obj.getDouble(field.getName()));
                            break;
                        case "boolean":
                            aux.getClass().getField(field.getName()).set(aux, obj.getBoolean(field.getName()));
                            break;
                        default:
                            Class c = Class.forName(field.getType().getName());
                            aux.getClass().getField(field.getName()).set(aux, injetarValor(c, obj.getJSONObject(field.getName())));
                            break;
                    }
                }
                retorno.add(aux);
            }
            return retorno;
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | JSONException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    private Object injetarValor(Class classe, JSONObject obj) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException, ClassNotFoundException {
        try {
            Object retorno = classe.newInstance();

            for (Field field : classe.getFields()) {
                switch (field.getType().getName().toLowerCase()) {
                    case "java.lang.string":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getString(field.getName()));
                        break;
                    case "int":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getInt(field.getName()));
                        break;
                    case "integer":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getInt(field.getName()));
                        break;
                    case "double":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getDouble(field.getName()));
                        break;
                    case "boolean":
                        retorno.getClass().getField(field.getName()).set(retorno, obj.getBoolean(field.getName()));
                        break;
                    default:
                        Class c = Class.forName(field.getType().getName());
                        retorno.getClass().getField(field.getName()).set(retorno, injetarValor(c, obj.getJSONObject(field.getName())));
                        break;
                }
            }
            return retorno;
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | JSONException | ClassNotFoundException ex) {
            throw ex;
        }
    }
}
