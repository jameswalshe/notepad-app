package com.kainos.ea.resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kainos.ea.Id;
import com.kainos.ea.Note;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/api")
public class NotepadWebService {

    @GET
    @Path("/notes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getNotes() throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get("/Users/jameswalshe/IdeaProjects/NotepadWebService/src/main/java/com/kainos/ea/db/notes.json"));
        List<Note> notes = new Gson().fromJson(reader, new TypeToken<List<Note>>() {}.getType());
        reader.close();
        return notes;
    }

    @GET
    @Path("/viewNote/{noteId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> getNote(@PathParam("noteId") String id) throws IOException {

        Id nid = new Id(id);
        List<Note> note = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get("/Users/jameswalshe/IdeaProjects/NotepadWebService/src/main/java/com/kainos/ea/db/notes.json"));
        List<Note> notes = new Gson().fromJson(reader, new TypeToken<List<Note>>() {}.getType());

        if(notes.size() == 1){
            if(notes.get(0).getId().equalsIgnoreCase(nid.getId())){
                note.add(notes.get(0));
            }
        } else {
            for(Note n: notes){
                if(n.getId().equalsIgnoreCase(nid.getId())){
                    note.add(n);
                }
            }
        }
        return note;
    }
    @POST
    @Path("/note")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addNote(Note note) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("/Users/jameswalshe/IdeaProjects/NotepadWebService/src/main/java/com/kainos/ea/db/notes.json"));
        List<Note> notes = new Gson().fromJson(reader, new TypeToken<List<Note>>() {}.getType());
        Note newNote = new Note(note.getName(), note.getNote(), note.getId());
        notes.add(newNote);
        FileWriter fw = new FileWriter("/Users/jameswalshe/IdeaProjects/NotepadWebService/src/main/java/com/kainos/ea/db/notes.json" );
        new Gson().toJson(notes, fw);
        fw.close();
    }

    @POST
    @Path("/deleteNote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteNote(Id id) throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("/Users/jameswalshe/IdeaProjects/NotepadWebService/src/main/java/com/kainos/ea/db/notes.json"));
        List<Note> notes = new Gson().fromJson(reader, new TypeToken<List<Note>>() {}.getType());

        if(notes.size() == 1){
            if(notes.get(0).getId().equals(id.getId())){
                notes.remove(notes.get(0));
            }
        } else {
            for(Note n: notes){
                if(n.getId().equals(id.getId())){
                    notes.remove(n);
                    break;
                }
            }
        }


        FileWriter fw = new FileWriter("/Users/jameswalshe/IdeaProjects/NotepadWebService/src/main/java/com/kainos/ea/db/notes.json" );
        new Gson().toJson(notes, fw);
        fw.close();
    }
}
