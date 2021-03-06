/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.receiver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NandaPC
 */
public class Receiver extends UnicastRemoteObject implements ReceiveIF{

    public Receiver() throws RemoteException{
    }
    
    @Override
    public String sendServerApp(String msg) throws RemoteException{
        try {
            Cliente cliente = new Cliente();
            return cliente.getLockup().processMessage(msg);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Erro";
        }

    @Override
    public String receiver(String msg) throws RemoteException{
        return sendServerApp(msg);
    }
    
    
}
