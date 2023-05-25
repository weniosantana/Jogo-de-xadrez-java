package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	
	@Override
	public String toString() {
		return "r";
	}


	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		
		//Acima
		p.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			
			mat[p.getRow()][p.getColumn()] = true;

		}
		
		//Esquerda
		p.setValues(position.getRow(), position.getColumn() - 1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
			mat[p.getRow()][p.getColumn()] = true;

		}
		
		//Direita
				p.setValues(position.getRow(), position.getColumn() + 1);
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setColumn(p.getColumn() + 1);
				}if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
					mat[p.getRow()][p.getColumn()] = true;

				}
		//Baixo
				p.setValues(position.getRow() + 1, position.getColumn());
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setRow(p.getRow() + 1);
				}
					
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					
				mat[p.getRow()][p.getColumn()] = true;

}
				
				//NR
				p.setValues(position.getRow() - 1, position.getColumn() - 1);
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setValues(p.getRow() - 1, p.getColumn() - 1);
				}
				
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					
					mat[p.getRow()][p.getColumn()] = true;

				}
				
				//ND
				p.setValues(position.getRow() - 1, position.getColumn() + 1);
				while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
					p.setValues(p.getRow() - 1, p.getColumn() + 1);
				}if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
					mat[p.getRow()][p.getColumn()] = true;

				}
				
				//SD
						p.setValues(position.getRow() + 1, position.getColumn() + 1);
						while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
							mat[p.getRow()][p.getColumn()] = true;
							p.setValues(p.getRow() + 1, p.getColumn() + 1);
						}if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
							mat[p.getRow()][p.getColumn()] = true;

						}
				//SDE
						p.setValues(position.getRow() + 1, position.getColumn() - 1);
						while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
							mat[p.getRow()][p.getColumn()] = true;
							p.setValues(p.getRow() + 1, p.getColumn() - 1);
						}
							
						if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
							
						mat[p.getRow()][p.getColumn()] = true;

		}	
				
				
				
				
		return mat;
	}
}
