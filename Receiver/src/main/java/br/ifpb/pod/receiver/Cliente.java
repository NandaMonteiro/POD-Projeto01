/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.receiver;

import br.ifpb.pod.serverApp.RemoteServer;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author NandaPC
 */
public class Cliente {
    
    private Registry registry;
    private RemoteServer lockup; 

    public Cliente() throws RemoteException, NotBoundException {
        this.registry = LocateRegistry.getRegistry("localhost", 8080);
        lockup = (RemoteServer) registry.lookup("ServerApp");
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    public RemoteServer getLockup() {
        return lockup;
    }

    public void setLockup(RemoteServer lockup) {
        this.lockup = lockup;
    }
    
    
}
