package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ChessMatch chessmatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		
		while (!chessmatch.getCheckMate()) {
		try {
			UI.clearScreen();
			UI.printMatch(chessmatch, captured);
			System.out.println();
			System.out.print("Origem: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			boolean[][] possibleMoves = chessmatch.possibleMoves(source);
			UI.clearScreen();
			UI.printBoard(chessmatch.getPieces(), possibleMoves);
			
			
			System.out.println();
			System.out.print("Destino: ");
			ChessPosition target = UI.readChessPosition(sc);
			ChessPiece capturedPiece = chessmatch.perfomChessMove(source, target);

			

			if(capturedPiece != null) {	
				captured.add(capturedPiece);
			}
			
			if(chessmatch.getPromoted() != null) {
				System.out.print("Escolha a sua promoção (B/C/T/r)");
				String type = sc.nextLine();
				while(!type.equals("B") && !type.equals("C") && !type.equals("T") && !type.equals("r")) {
					System.out.print("Invalido! Escolha a sua promoção (B/C/T/r)");
					type = sc.nextLine();

				}
				chessmatch.replacePromotedPiece(type);
			}
			
		}
		catch(ChessException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		}
		UI.clearScreen();
		UI.printMatch(chessmatch, captured);
	}

}
