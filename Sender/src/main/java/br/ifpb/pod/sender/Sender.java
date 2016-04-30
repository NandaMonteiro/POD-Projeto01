/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpb.pod.sender;

import br.ifpb.pod.receiver.ReceiveIF;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NandaPC
 */
public class Sender extends UnicastRemoteObject implements SenderIF {

    
    private String resposta;
    private List<String> listaExecoes;
    public Sender() throws RemoteException {
        super();
    }

    @Override
    public String enviarMensagem(String mensagem) throws RemoteException {
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry(8081);
            ReceiveIF receiveIF = (ReceiveIF) registry.lookup("ReceiveIF");
            try {
                resposta = receiveIF.receiver(mensagem);
                return resposta; 
            } catch (RemoteException e) {
                throw new RemoteException("Erro na Conexão! Limite expirado");
            }
            
        } catch (NotBoundException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(resposta == null){
            listaExecoes.add("Resposta Nula ");
        }else{
            return "Mensagem recebida "+ resposta;
        }
        return "erro";
    }
    
//    public void recebimentoMensagem() throws RemoteException, NotBoundException, Exception{
//        if(resposta != null){
//            listaExecoes.add("Mensagem recebida!" + resposta);
//        }
//    }

}
