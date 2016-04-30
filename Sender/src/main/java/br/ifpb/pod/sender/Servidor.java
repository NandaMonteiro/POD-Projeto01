/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.sender;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author NandaPC
 */
public class Servidor {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.setProperty("sun.rmi.transport.tcp.responseTimeout", "180000");
        Registry registry = LocateRegistry.createRegistry(8082);
        registry.bind("SenderIF", new Sender());
    }
    
}
