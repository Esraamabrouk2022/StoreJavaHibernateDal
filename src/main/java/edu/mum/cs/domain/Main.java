package edu.mum.cs.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.mum.cs.Entity.Branch;
import edu.mum.cs.Entity.Brand;
import edu.mum.cs.Repo.GenaricRepoImp;

public class Main {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs");

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Brand brand =new Brand();
		brand.setLogo_path("HHHHHHHHH");
         
		GenaricRepoImp<Brand> braRepo=new GenaricRepoImp<Brand>(em,Brand.class);
		braRepo.insert(brand, em);
		em.getTransaction().commit();
		em.close();
	}

}
