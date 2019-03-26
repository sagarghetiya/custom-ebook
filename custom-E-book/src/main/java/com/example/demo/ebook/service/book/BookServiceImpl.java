package com.example.demo.ebook.service.book;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.publisher.Publisher;
import com.example.demo.ebook.repository.book.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository repository;
	@Override
	public Book registerBook(Book book,Publisher publisher) {
		book.setPublisher(publisher);
		Book save = repository.save(book);
		return save;
	}
	@Override
	public int saveBook(MultipartFile file, Book book, int publisherId) throws IOException {
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			String homeDir = System.getProperty("user.home");
			System.out.println(homeDir);
			String destination = homeDir+"/ebooks/publisher_"+publisherId+"/book_"+book.getId()+"/complete_book.pdf";
			File file2 = new File(destination);
			file2.getParentFile().mkdirs();
			FileUtils.writeByteArrayToFile(file2, bytes);
			book.setBookLoc(destination);
			book.setChaptersAdded(false);
			repository.save(book);
		}
		return 0;
	}

}
