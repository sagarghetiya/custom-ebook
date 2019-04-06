package com.example.demo.ebook.service.customEBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.customEBook.CustomEBook;
import com.example.demo.ebook.repository.customEBook.EbookRepository;

@Service
public class EbookServiceImpl implements EbookService{
	@Autowired
	EbookRepository repository;

	@Override
	public List<CustomEBook> showContent(Buyer buyer)
	{
		List<CustomEBook> ebooks=repository.findByBuyerOrderBySequence(buyer);
		return ebooks;	
	}
	@Override
	public void deleteChapter(int id)
	{
		List<CustomEBook> ebooks=repository.findById(id);
		CustomEBook ebook=ebooks.get(0);
		repository.delete(ebook);
	}
	@Override
	public int updateEbook(List<Integer>ebookid,List<Integer>sequence)
	{ 	int i;
		for( i=0;i<ebookid.size();i++)
		{
			int id=((Integer)ebookid.get(i)).intValue();
			int seq=((Integer)sequence.get(i)).intValue();
			List<CustomEBook> ebooks=repository.findById(id);
			CustomEBook b=(CustomEBook)ebooks.get(0);
			b.setSequence(seq);
			repository.save(b);
		}
		if(i==ebookid.size())
			return 1;
		else return 0;
	}
	@Override
	public void deleteContentAfterSave(Buyer buyer)
	{
		List<CustomEBook> ebooks=repository.findByBuyerOrderBySequence(buyer);
		for(int i=0;i<ebooks.size();i++)
		{
			CustomEBook ebook=ebooks.get(i);
			repository.delete(ebook);
		}
	}
}
