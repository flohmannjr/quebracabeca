package edu.flj.quebracabeca.Alfanumericos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Collections;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class AlfanumericosPanelBotoes extends JPanel
{
  private int       layout;
  private JButton[] botoes;
  private Vector    referencia;
  private Vector    vetor;
  private byte      lado;

  private AlfanumericosPanelBotoesActionListener aListener;

  private AlfanumericosLetras   alfaLetras;
  private AlfanumericosNumeros  alfaNumeros;
  private AlfanumericosPalavras alfaPalavras;

  public AlfanumericosPanelBotoes(int layout)
  {
    this.layout = layout;

    lado = 0;

    aListener = new AlfanumericosPanelBotoesActionListener(this);

    alfaLetras   = new AlfanumericosLetras(aListener);
    alfaNumeros  = new AlfanumericosNumeros(aListener);
    alfaPalavras = new AlfanumericosPalavras(aListener);

    switch(layout)
    {
      case 0:
        botoes = alfaLetras.getLetras(15);
        vetor  = embaralhar(botoes);
        lado   = 4;
        break;
      case 1:
        botoes = alfaNumeros.getNumeros(15);
        vetor  = embaralhar(botoes);
        lado   = 4;
        break;
      case 2:
        botoes = alfaLetras.getLetras(24);
        vetor  = embaralhar(botoes);
        lado   = 5;
        break;
      case 3:
        botoes = alfaNumeros.getNumeros(24);
        vetor  = embaralhar(botoes);
        lado   = 5;
        break;
      case 4:
        botoes = alfaPalavras.getPalavras(0);
        vetor  = embaralhar(botoes);
        lado   = 6;
        break;
      case 5:
        botoes = alfaNumeros.getNumeros(35);
        vetor  = embaralhar(botoes);
        lado   = 6;
        break;
      case 6:
        botoes = alfaPalavras.getPalavras(1);
        vetor  = embaralhar(botoes);
        lado   = 7;
        break;
      case 7:
        botoes = alfaNumeros.getNumeros(48);
        vetor  = embaralhar(botoes);
        lado   = 7;
        break;
    }

    montaPainel();
  }

  private Vector embaralhar(JButton[] btnBotoes)
  {
    Vector vetorS = new Vector(btnBotoes.length);

    for(int l = 0; l < btnBotoes.length; l++)
    {
      vetorS.add(btnBotoes[l]);
    }

    Collections.shuffle(vetorS);

    JButton botao = new JButton();

    botao.setActionCommand("n");
    botao.setBackground(Color.WHITE);
    botao.setPreferredSize(new Dimension(50, 50));

    vetorS.add(botao);

    return vetorS;
  }

  private void montaPainel()
  {
    removeAll();

    setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    setLayout(new GridLayout(lado, lado));

    referencia = new Vector(lado * lado);

    criaReferencia();
    adicionaBotoes();
  }

  private void criaReferencia()
  {
    for(int r = 0; r < vetor.size(); r++)
    {
      referencia.add(((JButton)vetor.elementAt(r)).getActionCommand());
    }
  }

  private void adicionaBotoes()
  {
    for(int v = 0; v < vetor.size(); v++)
    {
      add((JButton)vetor.elementAt(v));
    }
  }

  public void mudaPosicao(String comando)
  {
    int posicaoBotao = referencia.indexOf(comando);
    int posicaoNulo  = referencia.indexOf("n");

    if(mudancaValida(posicaoBotao, posicaoNulo) == true)
    {
      JButton botao = (JButton)vetor.elementAt(posicaoBotao);
      JButton nulo  = (JButton)vetor.elementAt(posicaoNulo);

      referencia.setElementAt("n", posicaoBotao);
      referencia.setElementAt(comando, posicaoNulo);

      vetor.setElementAt(nulo, posicaoBotao);
      vetor.setElementAt(botao, posicaoNulo);

      removeAll();
      adicionaBotoes();
      updateUI();

      verificaSolucao();
    }
  }

  private boolean mudancaValida(int posicaoBotao, int posicaoNulo)
  {
    if(((posicaoNulo == posicaoBotao - lado) &&
        (posicaoNulo < lado * (lado - 1)))      ||
       ((posicaoNulo == posicaoBotao + 1)    &&
        (posicaoNulo % lado > 0))               ||
       ((posicaoNulo == posicaoBotao + lado) &&
        (posicaoNulo >= lado))                  ||
       ((posicaoNulo == posicaoBotao - 1)    &&
        ((posicaoNulo + 1) % lado > 0)))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  private void verificaSolucao()
  {
    switch(layout)
    {
      case 0:
        if(listasSemelhantes(AlfanumericosLayout.SOLUCAO_INICIANTE_LETRAS, true))
        {
          JOptionPane.showMessageDialog(this, "Fim do Jogo! Parabéns!");
        }

        break;
      case 1:
        if(listasSemelhantes(AlfanumericosLayout.SOLUCAO_INICIANTE_NUMEROS, false))
        {
          JOptionPane.showMessageDialog(this, "Fim do Jogo! Parabéns!");
        }

        break;
      case 2:
        if(listasSemelhantes(AlfanumericosLayout.SOLUCAO_FACIL_LETRAS, true))
        {
          JOptionPane.showMessageDialog(this, "Fim do Jogo! Parabéns!");
        }

        break;
      case 3:
        if(listasSemelhantes(AlfanumericosLayout.SOLUCAO_FACIL_NUMEROS, false))
        {
          JOptionPane.showMessageDialog(this, "Fim do Jogo! Parabéns!");
        }

        break;
      case 4:
        if(listasSemelhantes(AlfanumericosLayout.SOLUCAO_MEDIO_LETRAS, true))
        {
          JOptionPane.showMessageDialog(this, "Fim do Jogo! Parabéns!");
        }

        break;
      case 5:
        if(listasSemelhantes(AlfanumericosLayout.SOLUCAO_MEDIO_NUMEROS, false))
        {
          JOptionPane.showMessageDialog(this, "Fim do Jogo! Parabéns!");
        }

        break;
      case 6:
        if(listasSemelhantes(AlfanumericosLayout.SOLUCAO_DIFICIL_LETRAS, true))
        {
          JOptionPane.showMessageDialog(this, "Fim do Jogo! Parabéns!");
        }

        break;
      case 7:
        if(listasSemelhantes(AlfanumericosLayout.SOLUCAO_DIFICIL_NUMEROS, false))
        {
          JOptionPane.showMessageDialog(this, "Fim do Jogo! Parabéns!");
        }

        break;
    }
  }

  private boolean listasSemelhantes(String[] solucao, boolean letras)
  {
    if(solucao.length != referencia.size())
    {
      return false;
    }

    for(int v = 0; v < referencia.size(); v++)
    {
      if(letras == true)
      {
        if(!((String)referencia.elementAt(v)).equals(Character.toString(solucao[v].charAt(0))))
        {
          return false;
        }
      }
      else
      {
        if(!((String)referencia.elementAt(v)).equals(solucao[v]))
        {
          return false;
        }
      }
    }

    return true;
  }
}