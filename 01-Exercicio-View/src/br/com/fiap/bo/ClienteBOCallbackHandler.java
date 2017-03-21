
/**
 * ClienteBOCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package br.com.fiap.bo;

    /**
     *  ClienteBOCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ClienteBOCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ClienteBOCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ClienteBOCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for listar method
            * override this method for handling normal response from listar operation
            */
           public void receiveResultlistar(
                    br.com.fiap.bo.ClienteBOStub.ListarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listar operation
           */
            public void receiveErrorlistar(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for buscar method
            * override this method for handling normal response from buscar operation
            */
           public void receiveResultbuscar(
                    br.com.fiap.bo.ClienteBOStub.BuscarResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from buscar operation
           */
            public void receiveErrorbuscar(java.lang.Exception e) {
            }
                
               // No methods generated for meps other than in-out
                


    }
    