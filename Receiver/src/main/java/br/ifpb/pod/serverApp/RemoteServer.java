/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.serverApp;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NandaPC
 */
public interface RemoteServer extends Remote{

    public String processMessage(String msg) throws RemoteException;
}
