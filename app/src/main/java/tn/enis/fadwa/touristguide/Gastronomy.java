package tn.enis.fadwa.touristguide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gastronomy {
	String nom;
	double lat;
	double lg;

	public Gastronomy(String nom) {
		this.nom = nom;

	}

	public static ArrayList<Gastronomy> retournerTout(double lat, double lg, ArrayList<Gastronomy> a) {
		ArrayList<Gastronomy> a1 = new ArrayList<Gastronomy>();
		for (int i = 0; i < a.size(); i++) {
			double dist = DistanceCalculator.distance(a.get(i).lat, a.get(i).lg, lat, lg);
			if(Math.abs(dist)<4){
				a1.add(a.get(i));
			}
		}
		Collections.sort(a1, new Comparator<Gastronomy>() {

			@Override
			public int compare(Gastronomy o1, Gastronomy o2) {
				try {
					return o1.nom.compareTo(o2.nom);
				} catch (Exception e) {
					return 0;
				}
			}
		});

		return a1;

	}

	public static ArrayList<Gastronomy> rechercheByName(ArrayList<Gastronomy> a, String name) {
		ArrayList<Gastronomy> a2 = new ArrayList<Gastronomy>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).nom.equals(name)) {
				a2.add(a.get(i));
			}
		}

		Collections.sort(a2, new Comparator<Gastronomy>() {

			@Override
			public int compare(Gastronomy o1, Gastronomy o2) {
				try {
					return o1.nom.compareTo(o2.nom);
				} catch (Exception e) {
					return 0;
				}
			}
		});

		return a2;

	}

	public static ArrayList<Gastronomy> rechercheByType(ArrayList<Gastronomy> a, String type) {
		ArrayList<Gastronomy> a2 = new ArrayList<Gastronomy>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).nom.equals(type)) {
				a2.add(a.get(i));
			}
		}

		Collections.sort(a2, new Comparator<Gastronomy>() {

			@Override
			public int compare(Gastronomy o1, Gastronomy o2) {
				try {
					return o1.nom.compareTo(o2.nom);
				} catch (Exception e) {
					return 0;
				}
			}
		});

		return a2;

	}

	public static ArrayList<Gastronomy> rechercheByPlace(ArrayList<Gastronomy> a, String place) {
		ArrayList<Gastronomy> a2 = new ArrayList<Gastronomy>();
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).nom.equals(place)) {
				a2.add(a.get(i));
			}
		}

		Collections.sort(a2, new Comparator<Gastronomy>() {

			@Override
			public int compare(Gastronomy o1, Gastronomy o2) {
				try {
					return o1.nom.compareTo(o2.nom);
				} catch (Exception e) {
					return 0;
				}
			}
		});

		return a2;
	}

	String getNom() {
		return nom;
	}
}
