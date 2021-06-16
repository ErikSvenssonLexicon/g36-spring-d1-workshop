package se.lexicon.g36_spring_di.util;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScannerInputService implements UserInputService{
	
	private final Scanner scanner;	

	@Autowired
	public ScannerInputService(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public String getString() {
		return scanner.nextLine();
	}

	@Override
	public int getInt() throws NumberFormatException {		
		return Integer.parseInt(getString().trim());		
	}

}
