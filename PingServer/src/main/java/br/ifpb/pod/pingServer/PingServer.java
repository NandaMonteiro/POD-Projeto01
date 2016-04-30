/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.pingServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author NandaPC
 */
public class PingServer extends UnicastRemoteObject implements PingServerIF{

    public PingServer() throws RemoteException{
        super();
    }

    @Override
    public String ping()throws RemoteException{
       return "Ping";
    }

    
    
    
    
}
