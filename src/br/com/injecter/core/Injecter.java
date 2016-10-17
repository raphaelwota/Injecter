package br.com.injecter.core;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

    public class Injecter<T> {
        
        public T injectFrom (T entity, JSONObject obj) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException, ClassNotFoundException {
            Class<T> classe = (Class<T>) entity.getClass();
            try {
                T retorno = classe.newInstance();
                
                for(Field field : classe.getFields()){
                    
                    switch (field.getType().getName().toLowerCase()){
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
                            retorno.getClass().getField(field.getName()).set(retorno, injetarValor(c, obj.getJSONObject(field.getName())) );
                            break;
                    }
                }
                return retorno;
            } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | JSONException | ClassNotFoundException ex) {
                throw ex;
            }
        }
        
        private Object injetarValor (Class classe, JSONObject obj ) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, JSONException, ClassNotFoundException {
            try {
                Object retorno = classe.newInstance();
                
                for (Field field : classe.getFields()){
                    switch (field.getType().getName().toLowerCase()){
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
                            retorno.getClass().getField(field.getName()).set(retorno, injetarValor(c, obj.getJSONObject(field.getName())) );
                            break;
                    }
                }
                return retorno;
            } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException | JSONException | ClassNotFoundException ex) {
                throw ex;
            }
        }
    }