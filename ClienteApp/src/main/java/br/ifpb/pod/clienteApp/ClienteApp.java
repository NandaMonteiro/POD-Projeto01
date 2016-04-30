/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.clienteApp;

import br.ifpb.pod.sender.SenderIF;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author NandaPC
 */
public class ClienteApp {
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(8082);
        SenderIF sender = (SenderIF) registry.lookup("SenderIF");
        System.out.println(sender.enviarMensagem("Fernanda"));
        
        
    }
}
