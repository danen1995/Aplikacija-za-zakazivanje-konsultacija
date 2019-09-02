package rs.ac.bg.fon.silab.AppKons.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.silab.AppKons.dto.ClanstvoKomisijeDTO;
import rs.ac.bg.fon.silab.AppKons.dto.DogadjajDTO;
import rs.ac.bg.fon.silab.AppKons.dto.DogadjajPKDTO;
import rs.ac.bg.fon.silab.AppKons.dto.KalendarDTO;
import rs.ac.bg.fon.silab.AppKons.dto.KonsultacijeDTO;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;
import rs.ac.bg.fon.silab.AppKons.dto.NastavaDTO;
import rs.ac.bg.fon.silab.AppKons.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AppKons.dto.PokrivenostNastaveDTO;
import rs.ac.bg.fon.silab.AppKons.dto.PokrivenostNastavePKDTO;
import rs.ac.bg.fon.silab.AppKons.dto.PredmetDTO;
import rs.ac.bg.fon.silab.AppKons.dto.PrilogDTO;
import rs.ac.bg.fon.silab.AppKons.dto.SkolskaGodinaDTO;
import rs.ac.bg.fon.silab.AppKons.dto.StudentDTO;
import rs.ac.bg.fon.silab.AppKons.dto.StudentKonsultacijeDTO;
import rs.ac.bg.fon.silab.AppKons.dto.StudentKonsultacijePKDTO;
import rs.ac.bg.fon.silab.AppKons.dto.TipDogadjajaDTO;
import rs.ac.bg.fon.silab.AppKons.entities.ClanstvoKomisije;
import rs.ac.bg.fon.silab.AppKons.entities.Dogadjaj;
import rs.ac.bg.fon.silab.AppKons.entities.DogadjajPK;
import rs.ac.bg.fon.silab.AppKons.entities.Kalendar;
import rs.ac.bg.fon.silab.AppKons.entities.Konsultacije;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.entities.Nastava;
import rs.ac.bg.fon.silab.AppKons.entities.Nastavnik;
import rs.ac.bg.fon.silab.AppKons.entities.PokrivenostNastave;
import rs.ac.bg.fon.silab.AppKons.entities.PokrivenostNastavePK;
import rs.ac.bg.fon.silab.AppKons.entities.Predmet;
import rs.ac.bg.fon.silab.AppKons.entities.Prilog;
import rs.ac.bg.fon.silab.AppKons.entities.SkolskaGodina;
import rs.ac.bg.fon.silab.AppKons.entities.Student;
import rs.ac.bg.fon.silab.AppKons.entities.StudentKonsultacije;
import rs.ac.bg.fon.silab.AppKons.entities.StudentKonsultacijePK;
import rs.ac.bg.fon.silab.AppKons.entities.TipDogadjaja;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-11T16:40:47+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_65 (Oracle Corporation)"
)
@Component
public class GenericMapperImpl implements GenericMapper {

    @Override
    public KorisnickiNalogDTO korisnickiNalogToKorisnickiNalogDTO(KorisnickiNalog korisnickiNalog) {
        if ( korisnickiNalog == null ) {
            return null;
        }

        KorisnickiNalogDTO korisnickiNalogDTO = new KorisnickiNalogDTO();

        korisnickiNalogDTO.setKorisnickoIme( korisnickiNalog.getKorisnickoIme() );
        korisnickiNalogDTO.setLozinka( korisnickiNalog.getLozinka() );
        korisnickiNalogDTO.setNastavnik( nastavnikToNastavnikDTO( korisnickiNalog.getNastavnik() ) );
        korisnickiNalogDTO.setStudent( studentToStudentDTO( korisnickiNalog.getStudent() ) );

        return korisnickiNalogDTO;
    }

    @Override
    public KorisnickiNalog korisnickiNalogDTOToKorisnickiNalog(KorisnickiNalogDTO korisnickiNalogDTO) {
        if ( korisnickiNalogDTO == null ) {
            return null;
        }

        KorisnickiNalog korisnickiNalog = new KorisnickiNalog();

        korisnickiNalog.setKorisnickoIme( korisnickiNalogDTO.getKorisnickoIme() );
        korisnickiNalog.setLozinka( korisnickiNalogDTO.getLozinka() );
        korisnickiNalog.setNastavnik( nastavnikDTOToNastavnik( korisnickiNalogDTO.getNastavnik() ) );
        korisnickiNalog.setStudent( studentDTOToStudent( korisnickiNalogDTO.getStudent() ) );

        return korisnickiNalog;
    }

    @Override
    public Student studentDTOToStudent(StudentDTO s) {
        if ( s == null ) {
            return null;
        }

        Student student = new Student();

        student.setBrojIndeksa( s.getBrojIndeksa() );
        student.setIme( s.getIme() );
        student.setPrezime( s.getPrezime() );
        student.setGodinaUpisa( s.getGodinaUpisa() );
        student.setSmer( s.getSmer() );
        student.setBrojTelefona( s.getBrojTelefona() );
        student.setEmail( s.getEmail() );

        return student;
    }

    @Override
    public StudentDTO studentToStudentDTO(Student s) {
        if ( s == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setBrojIndeksa( s.getBrojIndeksa() );
        studentDTO.setIme( s.getIme() );
        studentDTO.setPrezime( s.getPrezime() );
        studentDTO.setGodinaUpisa( s.getGodinaUpisa() );
        studentDTO.setSmer( s.getSmer() );
        studentDTO.setBrojTelefona( s.getBrojTelefona() );
        studentDTO.setEmail( s.getEmail() );

        return studentDTO;
    }

    @Override
    public Nastava nastavaDTOToNastava(NastavaDTO nastavaDTO) {
        if ( nastavaDTO == null ) {
            return null;
        }

        Nastava nastava = new Nastava();

        nastava.setDogadjajPK( dogadjajPKDTOToDogadjajPK( nastavaDTO.getDogadjajPK() ) );
        nastava.setDatumIVremePocetka( nastavaDTO.getDatumIVremePocetka() );
        nastava.setDatumIVremeZavrsetka( nastavaDTO.getDatumIVremeZavrsetka() );
        nastava.setMestoOdrzavanja( nastavaDTO.getMestoOdrzavanja() );
        nastava.setKalendar( kalendarDTOToKalendar( nastavaDTO.getKalendar() ) );
        nastava.setIdTipaDogadjaja( tipDogadjajaDTOToTipDogadjaja( nastavaDTO.getIdTipaDogadjaja() ) );
        nastava.setUlogaNastave( nastavaDTO.getUlogaNastave() );
        nastava.setIdPredmeta( predmetDTOToPredmet( nastavaDTO.getIdPredmeta() ) );

        return nastava;
    }

    @Override
    public NastavaDTO nastavaToNastavaDTO(Nastava nastava) {
        if ( nastava == null ) {
            return null;
        }

        NastavaDTO nastavaDTO = new NastavaDTO();

        nastavaDTO.setDogadjajPK( dogadjajPKToDogadjajPKDTO( nastava.getDogadjajPK() ) );
        nastavaDTO.setDatumIVremePocetka( nastava.getDatumIVremePocetka() );
        nastavaDTO.setDatumIVremeZavrsetka( nastava.getDatumIVremeZavrsetka() );
        nastavaDTO.setMestoOdrzavanja( nastava.getMestoOdrzavanja() );
        nastavaDTO.setKalendar( kalendarToKalendarDTO( nastava.getKalendar() ) );
        nastavaDTO.setIdTipaDogadjaja( tipDogadjajaToTipDogadjajaDTO( nastava.getIdTipaDogadjaja() ) );
        nastavaDTO.setUlogaNastave( nastava.getUlogaNastave() );
        nastavaDTO.setIdPredmeta( predmetToPredmetDTO( nastava.getIdPredmeta() ) );

        return nastavaDTO;
    }

    @Override
    public ClanstvoKomisije clanstvoKomisijeDTOToClanstvoKomisije(ClanstvoKomisijeDTO clanstvoKomisjeDTO) {
        if ( clanstvoKomisjeDTO == null ) {
            return null;
        }

        ClanstvoKomisije clanstvoKomisije = new ClanstvoKomisije();

        clanstvoKomisije.setDogadjajPK( dogadjajPKDTOToDogadjajPK( clanstvoKomisjeDTO.getDogadjajPK() ) );
        clanstvoKomisije.setDatumIVremePocetka( clanstvoKomisjeDTO.getDatumIVremePocetka() );
        clanstvoKomisije.setDatumIVremeZavrsetka( clanstvoKomisjeDTO.getDatumIVremeZavrsetka() );
        clanstvoKomisije.setMestoOdrzavanja( clanstvoKomisjeDTO.getMestoOdrzavanja() );
        clanstvoKomisije.setKalendar( kalendarDTOToKalendar( clanstvoKomisjeDTO.getKalendar() ) );
        clanstvoKomisije.setIdTipaDogadjaja( tipDogadjajaDTOToTipDogadjaja( clanstvoKomisjeDTO.getIdTipaDogadjaja() ) );
        clanstvoKomisije.setNivo( clanstvoKomisjeDTO.getNivo() );
        clanstvoKomisije.setUloga( clanstvoKomisjeDTO.getUloga() );
        clanstvoKomisije.setKandidat( clanstvoKomisjeDTO.getKandidat() );
        clanstvoKomisije.setTema( clanstvoKomisjeDTO.getTema() );

        return clanstvoKomisije;
    }

    @Override
    public ClanstvoKomisijeDTO clanstvoKomisijeToClanstvoKomisijeDTO(ClanstvoKomisije clanstvoKomisje) {
        if ( clanstvoKomisje == null ) {
            return null;
        }

        ClanstvoKomisijeDTO clanstvoKomisijeDTO = new ClanstvoKomisijeDTO();

        clanstvoKomisijeDTO.setDogadjajPK( dogadjajPKToDogadjajPKDTO( clanstvoKomisje.getDogadjajPK() ) );
        clanstvoKomisijeDTO.setDatumIVremePocetka( clanstvoKomisje.getDatumIVremePocetka() );
        clanstvoKomisijeDTO.setDatumIVremeZavrsetka( clanstvoKomisje.getDatumIVremeZavrsetka() );
        clanstvoKomisijeDTO.setMestoOdrzavanja( clanstvoKomisje.getMestoOdrzavanja() );
        clanstvoKomisijeDTO.setKalendar( kalendarToKalendarDTO( clanstvoKomisje.getKalendar() ) );
        clanstvoKomisijeDTO.setIdTipaDogadjaja( tipDogadjajaToTipDogadjajaDTO( clanstvoKomisje.getIdTipaDogadjaja() ) );
        clanstvoKomisijeDTO.setNivo( clanstvoKomisje.getNivo() );
        clanstvoKomisijeDTO.setUloga( clanstvoKomisje.getUloga() );
        clanstvoKomisijeDTO.setKandidat( clanstvoKomisje.getKandidat() );
        clanstvoKomisijeDTO.setTema( clanstvoKomisje.getTema() );

        return clanstvoKomisijeDTO;
    }

    @Override
    public Nastavnik nastavnikDTOToNastavnik(NastavnikDTO s) {
        if ( s == null ) {
            return null;
        }

        Nastavnik nastavnik = new Nastavnik();

        nastavnik.setJmbg( s.getJmbg() );
        nastavnik.setIme( s.getIme() );
        nastavnik.setPrezime( s.getPrezime() );
        nastavnik.setEmail( s.getEmail() );
        nastavnik.setBrojTelefona( s.getBrojTelefona() );
        nastavnik.setSlika( s.getSlika() );
        nastavnik.setKabinet( s.getKabinet() );

        return nastavnik;
    }

    @Override
    public NastavnikDTO nastavnikToNastavnikDTO(Nastavnik s) {
        if ( s == null ) {
            return null;
        }

        NastavnikDTO nastavnikDTO = new NastavnikDTO();

        nastavnikDTO.setSlika( s.getSlika() );
        nastavnikDTO.setJmbg( s.getJmbg() );
        nastavnikDTO.setIme( s.getIme() );
        nastavnikDTO.setPrezime( s.getPrezime() );
        nastavnikDTO.setEmail( s.getEmail() );
        nastavnikDTO.setBrojTelefona( s.getBrojTelefona() );
        nastavnikDTO.setKabinet( s.getKabinet() );

        return nastavnikDTO;
    }

    @Override
    public KonsultacijeDTO konsultacijeToKonsultacijeDTO(Konsultacije konsultacije) {
        if ( konsultacije == null ) {
            return null;
        }

        KonsultacijeDTO konsultacijeDTO = new KonsultacijeDTO();

        konsultacijeDTO.setDogadjajPK( dogadjajPKToDogadjajPKDTO( konsultacije.getDogadjajPK() ) );
        konsultacijeDTO.setDatumIVremePocetka( konsultacije.getDatumIVremePocetka() );
        konsultacijeDTO.setDatumIVremeZavrsetka( konsultacije.getDatumIVremeZavrsetka() );
        konsultacijeDTO.setMestoOdrzavanja( konsultacije.getMestoOdrzavanja() );
        konsultacijeDTO.setKalendar( kalendarToKalendarDTO( konsultacije.getKalendar() ) );
        konsultacijeDTO.setIdTipaDogadjaja( tipDogadjajaToTipDogadjajaDTO( konsultacije.getIdTipaDogadjaja() ) );
        konsultacijeDTO.setKapacitet( konsultacije.getKapacitet() );
        konsultacijeDTO.setBrojZakazanih( konsultacije.getBrojZakazanih() );

        return konsultacijeDTO;
    }

    @Override
    public Konsultacije konsultacijeDTOToKonsultacije(KonsultacijeDTO konsultacijeDTO) {
        if ( konsultacijeDTO == null ) {
            return null;
        }

        Konsultacije konsultacije = new Konsultacije();

        konsultacije.setDatumIVremePocetka( konsultacijeDTO.getDatumIVremePocetka() );
        konsultacije.setDatumIVremeZavrsetka( konsultacijeDTO.getDatumIVremeZavrsetka() );
        konsultacije.setMestoOdrzavanja( konsultacijeDTO.getMestoOdrzavanja() );
        konsultacije.setKalendar( kalendarDTOToKalendar( konsultacijeDTO.getKalendar() ) );
        konsultacije.setIdTipaDogadjaja( tipDogadjajaDTOToTipDogadjaja( konsultacijeDTO.getIdTipaDogadjaja() ) );
        konsultacije.setDogadjajPK( dogadjajPKDTOToDogadjajPK( konsultacijeDTO.getDogadjajPK() ) );
        konsultacije.setKapacitet( konsultacijeDTO.getKapacitet() );
        konsultacije.setBrojZakazanih( konsultacijeDTO.getBrojZakazanih() );

        return konsultacije;
    }

    @Override
    public Dogadjaj dogadjajDTOToDogadjaj(DogadjajDTO dogadjajDTO) {
        if ( dogadjajDTO == null ) {
            return null;
        }

        Dogadjaj dogadjaj = new Dogadjaj();

        dogadjaj.setDogadjajPK( dogadjajPKDTOToDogadjajPK( dogadjajDTO.getDogadjajPK() ) );
        dogadjaj.setDatumIVremePocetka( dogadjajDTO.getDatumIVremePocetka() );
        dogadjaj.setDatumIVremeZavrsetka( dogadjajDTO.getDatumIVremeZavrsetka() );
        dogadjaj.setMestoOdrzavanja( dogadjajDTO.getMestoOdrzavanja() );
        dogadjaj.setKalendar( kalendarDTOToKalendar( dogadjajDTO.getKalendar() ) );
        dogadjaj.setIdTipaDogadjaja( tipDogadjajaDTOToTipDogadjaja( dogadjajDTO.getIdTipaDogadjaja() ) );

        return dogadjaj;
    }

    @Override
    public DogadjajDTO dogadjajToDogadjajDTO(Dogadjaj dogadjaj) {
        if ( dogadjaj == null ) {
            return null;
        }

        DogadjajDTO dogadjajDTO = new DogadjajDTO();

        dogadjajDTO.setDogadjajPK( dogadjajPKToDogadjajPKDTO( dogadjaj.getDogadjajPK() ) );
        dogadjajDTO.setDatumIVremePocetka( dogadjaj.getDatumIVremePocetka() );
        dogadjajDTO.setDatumIVremeZavrsetka( dogadjaj.getDatumIVremeZavrsetka() );
        dogadjajDTO.setMestoOdrzavanja( dogadjaj.getMestoOdrzavanja() );
        dogadjajDTO.setKalendar( kalendarToKalendarDTO( dogadjaj.getKalendar() ) );
        dogadjajDTO.setIdTipaDogadjaja( tipDogadjajaToTipDogadjajaDTO( dogadjaj.getIdTipaDogadjaja() ) );

        return dogadjajDTO;
    }

    @Override
    public DogadjajPK dogadjajPKDTOToDogadjajPK(DogadjajPKDTO dogadjajPKDTO) {
        if ( dogadjajPKDTO == null ) {
            return null;
        }

        DogadjajPK dogadjajPK = new DogadjajPK();

        dogadjajPK.setIdKalendara( dogadjajPKDTO.getIdKalendara() );
        dogadjajPK.setIdDogadjaja( dogadjajPKDTO.getIdDogadjaja() );

        return dogadjajPK;
    }

    @Override
    public DogadjajPKDTO dogadjajPKToDogadjajPKDTO(DogadjajPK dogadjajPK) {
        if ( dogadjajPK == null ) {
            return null;
        }

        DogadjajPKDTO dogadjajPKDTO = new DogadjajPKDTO();

        dogadjajPKDTO.setIdDogadjaja( dogadjajPK.getIdDogadjaja() );
        dogadjajPKDTO.setIdKalendara( dogadjajPK.getIdKalendara() );

        return dogadjajPKDTO;
    }

    @Override
    public Predmet predmetDTOToPredmet(PredmetDTO predmetDTO) {
        if ( predmetDTO == null ) {
            return null;
        }

        Predmet predmet = new Predmet();

        predmet.setNaziv( predmetDTO.getNaziv() );
        predmet.setEspbBodovi( predmetDTO.getEspbBodovi() );
        predmet.setGodinaStudija( predmetDTO.getGodinaStudija() );

        return predmet;
    }

    @Override
    public PredmetDTO predmetToPredmetDTO(Predmet predmet) {
        if ( predmet == null ) {
            return null;
        }

        PredmetDTO predmetDTO = new PredmetDTO();

        predmetDTO.setNaziv( predmet.getNaziv() );
        predmetDTO.setEspbBodovi( predmet.getEspbBodovi() );
        predmetDTO.setGodinaStudija( predmet.getGodinaStudija() );

        return predmetDTO;
    }

    @Override
    public Prilog prilogDTOToPrilog(PrilogDTO predmetDTO) {
        if ( predmetDTO == null ) {
            return null;
        }

        Prilog prilog = new Prilog();

        prilog.setIdPriloga( predmetDTO.getIdPriloga() );
        prilog.setNaziv( predmetDTO.getNaziv() );
        prilog.setLokacija( predmetDTO.getLokacija() );
        prilog.setStudentKonsultacije( studentKonsultacijeDTOToStudentKonsultacije( predmetDTO.getStudentKonsultacije() ) );

        return prilog;
    }

    @Override
    public PrilogDTO prilogToPrilogDTO(Prilog predmet) {
        if ( predmet == null ) {
            return null;
        }

        PrilogDTO prilogDTO = new PrilogDTO();

        prilogDTO.setIdPriloga( predmet.getIdPriloga() );
        prilogDTO.setNaziv( predmet.getNaziv() );
        prilogDTO.setLokacija( predmet.getLokacija() );
        prilogDTO.setStudentKonsultacije( studentKonsultacijeToStudentKonsultacijeDTO( predmet.getStudentKonsultacije() ) );

        return prilogDTO;
    }

    @Override
    public Kalendar kalendarDTOToKalendar(KalendarDTO kalendarDTO) {
        if ( kalendarDTO == null ) {
            return null;
        }

        Kalendar kalendar = new Kalendar();

        kalendar.setIdKalendara( kalendarDTO.getIdKalendara() );
        kalendar.setNastavnik( nastavnikDTOToNastavnik( kalendarDTO.getNastavnik() ) );
        kalendar.setIdSkolskeGodine( skolskaGodinaDTOToSkolskaGodina( kalendarDTO.getIdSkolskeGodine() ) );

        return kalendar;
    }

    @Override
    public KalendarDTO kalendarToKalendarDTO(Kalendar kalendar) {
        if ( kalendar == null ) {
            return null;
        }

        KalendarDTO kalendarDTO = new KalendarDTO();

        kalendarDTO.setIdKalendara( kalendar.getIdKalendara() );
        kalendarDTO.setNastavnik( nastavnikToNastavnikDTO( kalendar.getNastavnik() ) );
        kalendarDTO.setIdSkolskeGodine( skolskaGodinaToSkolskaGodinaDTO( kalendar.getIdSkolskeGodine() ) );

        return kalendarDTO;
    }

    @Override
    public PokrivenostNastave pokrivenostNastaveDTOToPokrivenostNastave(PokrivenostNastaveDTO pokrivenostNastaveDTO) {
        if ( pokrivenostNastaveDTO == null ) {
            return null;
        }

        PokrivenostNastave pokrivenostNastave = new PokrivenostNastave();

        pokrivenostNastave.setUloga( pokrivenostNastaveDTO.getUloga() );
        pokrivenostNastave.setNastavnik( nastavnikDTOToNastavnik( pokrivenostNastaveDTO.getNastavnik() ) );
        pokrivenostNastave.setPredmet( predmetDTOToPredmet( pokrivenostNastaveDTO.getPredmet() ) );
        pokrivenostNastave.setIdSkolskeGodine( skolskaGodinaDTOToSkolskaGodina( pokrivenostNastaveDTO.getIdSkolskeGodine() ) );

        return pokrivenostNastave;
    }

    @Override
    public PokrivenostNastaveDTO pokrivenostNastaveToPokrivenostNastaveDTO(PokrivenostNastave pokrivenostNastave) {
        if ( pokrivenostNastave == null ) {
            return null;
        }

        PokrivenostNastaveDTO pokrivenostNastaveDTO = new PokrivenostNastaveDTO();

        pokrivenostNastaveDTO.setUloga( pokrivenostNastave.getUloga() );
        pokrivenostNastaveDTO.setNastavnik( nastavnikToNastavnikDTO( pokrivenostNastave.getNastavnik() ) );
        pokrivenostNastaveDTO.setPredmet( predmetToPredmetDTO( pokrivenostNastave.getPredmet() ) );
        pokrivenostNastaveDTO.setIdSkolskeGodine( skolskaGodinaToSkolskaGodinaDTO( pokrivenostNastave.getIdSkolskeGodine() ) );
        pokrivenostNastaveDTO.setPokrivenostNastavePK( pokrivenostNastavePKToPokrivenostNastavePKDTO( pokrivenostNastave.getPokrivenostNastavePK() ) );

        return pokrivenostNastaveDTO;
    }

    @Override
    public PokrivenostNastavePK pokrivenostNastavePKDTOToPokrivenostNastavePK(PokrivenostNastavePKDTO pokrivenostNastavePKDTO) {
        if ( pokrivenostNastavePKDTO == null ) {
            return null;
        }

        PokrivenostNastavePK pokrivenostNastavePK = new PokrivenostNastavePK();

        pokrivenostNastavePK.setJmbgNastavnika( pokrivenostNastavePKDTO.getJmbgNastavnika() );
        pokrivenostNastavePK.setIdPredmeta( pokrivenostNastavePKDTO.getIdPredmeta() );

        return pokrivenostNastavePK;
    }

    @Override
    public PokrivenostNastavePKDTO pokrivenostNastavePKToPokrivenostNastavePKDTO(PokrivenostNastavePK pokrivenostNastavePK) {
        if ( pokrivenostNastavePK == null ) {
            return null;
        }

        PokrivenostNastavePKDTO pokrivenostNastavePKDTO = new PokrivenostNastavePKDTO();

        pokrivenostNastavePKDTO.setIdPredmeta( pokrivenostNastavePK.getIdPredmeta() );
        pokrivenostNastavePKDTO.setJmbgNastavnika( pokrivenostNastavePK.getJmbgNastavnika() );

        return pokrivenostNastavePKDTO;
    }

    @Override
    public SkolskaGodina skolskaGodinaDTOToSkolskaGodina(SkolskaGodinaDTO skolskaGodinaDTO) {
        if ( skolskaGodinaDTO == null ) {
            return null;
        }

        SkolskaGodina skolskaGodina = new SkolskaGodina();

        skolskaGodina.setIdSkolskeGodine( skolskaGodinaDTO.getIdSkolskeGodine() );
        skolskaGodina.setSkolskaGodina( skolskaGodinaDTO.getSkolskaGodina() );
        skolskaGodina.setSemestar( skolskaGodinaDTO.getSemestar() );

        return skolskaGodina;
    }

    @Override
    public SkolskaGodinaDTO skolskaGodinaToSkolskaGodinaDTO(SkolskaGodina skolskaGodina) {
        if ( skolskaGodina == null ) {
            return null;
        }

        SkolskaGodinaDTO skolskaGodinaDTO = new SkolskaGodinaDTO();

        skolskaGodinaDTO.setIdSkolskeGodine( skolskaGodina.getIdSkolskeGodine() );
        skolskaGodinaDTO.setSkolskaGodina( skolskaGodina.getSkolskaGodina() );
        skolskaGodinaDTO.setSemestar( skolskaGodina.getSemestar() );

        return skolskaGodinaDTO;
    }

    @Override
    public TipDogadjaja tipDogadjajaDTOToTipDogadjaja(TipDogadjajaDTO tipDogadjajaDTO) {
        if ( tipDogadjajaDTO == null ) {
            return null;
        }

        TipDogadjaja tipDogadjaja = new TipDogadjaja();

        tipDogadjaja.setIdTipaDogadjaja( tipDogadjajaDTO.getIdTipaDogadjaja() );
        tipDogadjaja.setNazivTipaDogadjaja( tipDogadjajaDTO.getNazivTipaDogadjaja() );

        return tipDogadjaja;
    }

    @Override
    public TipDogadjajaDTO tipDogadjajaToTipDogadjajaDTO(TipDogadjaja tipDogadjaja) {
        if ( tipDogadjaja == null ) {
            return null;
        }

        TipDogadjajaDTO tipDogadjajaDTO = new TipDogadjajaDTO();

        tipDogadjajaDTO.setIdTipaDogadjaja( tipDogadjaja.getIdTipaDogadjaja() );
        tipDogadjajaDTO.setNazivTipaDogadjaja( tipDogadjaja.getNazivTipaDogadjaja() );

        return tipDogadjajaDTO;
    }

    @Override
    public StudentKonsultacijeDTO studentKonsultacijeToStudentKonsultacijeDTO(StudentKonsultacije studentKonsultacije) {
        if ( studentKonsultacije == null ) {
            return null;
        }

        StudentKonsultacijeDTO studentKonsultacijeDTO = new StudentKonsultacijeDTO();

        studentKonsultacijeDTO.setStatus( studentKonsultacije.getStatus() );
        studentKonsultacijeDTO.setNaslov( studentKonsultacije.getNaslov() );
        studentKonsultacijeDTO.setOpis( studentKonsultacije.getOpis() );
        studentKonsultacijeDTO.setKonsultacije( konsultacijeToKonsultacijeDTO( studentKonsultacije.getKonsultacije() ) );
        studentKonsultacijeDTO.setStudent( studentToStudentDTO( studentKonsultacije.getStudent() ) );
        studentKonsultacijeDTO.setStudentKonsultacijePK( studentKonsultacijePKToStudentKonsultacijePKDTO( studentKonsultacije.getStudentKonsultacijePK() ) );

        return studentKonsultacijeDTO;
    }

    @Override
    public StudentKonsultacije studentKonsultacijeDTOToStudentKonsultacije(StudentKonsultacijeDTO studentKonsultacijeDTO) {
        if ( studentKonsultacijeDTO == null ) {
            return null;
        }

        StudentKonsultacije studentKonsultacije = new StudentKonsultacije();

        studentKonsultacije.setStudentKonsultacijePK( studentKonsultacijePKDTOToStudentKonsultacijePK( studentKonsultacijeDTO.getStudentKonsultacijePK() ) );
        studentKonsultacije.setStatus( studentKonsultacijeDTO.getStatus() );
        studentKonsultacije.setNaslov( studentKonsultacijeDTO.getNaslov() );
        studentKonsultacije.setOpis( studentKonsultacijeDTO.getOpis() );
        studentKonsultacije.setKonsultacije( konsultacijeDTOToKonsultacije( studentKonsultacijeDTO.getKonsultacije() ) );
        studentKonsultacije.setStudent( studentDTOToStudent( studentKonsultacijeDTO.getStudent() ) );

        return studentKonsultacije;
    }

    @Override
    public StudentKonsultacijePK studentKonsultacijePKDTOToStudentKonsultacijePK(StudentKonsultacijePKDTO studentKonsultacijePKDTO) {
        if ( studentKonsultacijePKDTO == null ) {
            return null;
        }

        StudentKonsultacijePK studentKonsultacijePK = new StudentKonsultacijePK();

        studentKonsultacijePK.setIdKalendara( studentKonsultacijePKDTO.getIdKalendara() );
        studentKonsultacijePK.setIdDogadjaja( studentKonsultacijePKDTO.getIdDogadjaja() );
        studentKonsultacijePK.setBrojIndeksaStudenta( studentKonsultacijePKDTO.getBrojIndeksaStudenta() );

        return studentKonsultacijePK;
    }

    @Override
    public StudentKonsultacijePKDTO studentKonsultacijePKToStudentKonsultacijePKDTO(StudentKonsultacijePK studentKonsultacijePK) {
        if ( studentKonsultacijePK == null ) {
            return null;
        }

        StudentKonsultacijePKDTO studentKonsultacijePKDTO = new StudentKonsultacijePKDTO();

        studentKonsultacijePKDTO.setBrojIndeksaStudenta( studentKonsultacijePK.getBrojIndeksaStudenta() );
        studentKonsultacijePKDTO.setIdKalendara( studentKonsultacijePK.getIdKalendara() );
        studentKonsultacijePKDTO.setIdDogadjaja( studentKonsultacijePK.getIdDogadjaja() );

        return studentKonsultacijePKDTO;
    }
}
