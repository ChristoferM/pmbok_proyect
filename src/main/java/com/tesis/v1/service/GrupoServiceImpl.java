package com.tesis.v1.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.FaseProyecto;
import com.tesis.v1.domain.Grupo;
import com.tesis.v1.domain.Proyecto;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.Roles;
import com.tesis.v1.domain.SubGrupo;
import com.tesis.v1.domain.Usuario;
import com.tesis.v1.domain.tipofases;
import com.tesis.v1.dto.ControlFasesDTO;
import com.tesis.v1.dto.CrearfaseConResponsablesDTO;
import com.tesis.v1.dto.GrupoDTO;
import com.tesis.v1.dto.ResponsablesDTO;
import com.tesis.v1.dto.RolesDTO;
import com.tesis.v1.dto.RolproyectoDTO;
import com.tesis.v1.dto.UsuariosDTO;
import com.tesis.v1.dto.idresponsable;
import com.tesis.v1.domain.RolProyecto;
import com.tesis.v1.repository.FaseProyectoRepository;
import com.tesis.v1.repository.GrupoRepository;
import com.tesis.v1.repository.ProyectoRepository;
import com.tesis.v1.repository.ReunionRepository;
import com.tesis.v1.repository.RolProyectoRepository;
import com.tesis.v1.repository.RolesRepository;
import com.tesis.v1.repository.SubGrupoRepository;
import com.tesis.v1.repository.UsuarioRepository;
import com.tesis.v1.repository.tipofasesRepository;

@Service
@Scope("singleton")
public class GrupoServiceImpl implements GrupoService {

	private final static Logger log = LoggerFactory.getLogger(GrupoServiceImpl.class);

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	tipofasesRepository tipoFasesRepository;
	@Autowired
	ProyectoRepository proyectoRepository;

	@Autowired
	SubGrupoRepository subGrupoRepository;

	@Autowired
	ReunionRepository reunionRepository;

	@Autowired
	FaseProyectoRepository faseProyectoRepository;

	@Autowired
	GrupoRepository grupoRepository;

	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	RolProyectoRepository rolProyectoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> findAll() {
		return grupoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Grupo> findById(Integer id) throws Exception {
		if (id <= 0 || id == null) {
			throw new Exception("error en peticion");
		} else {
			return grupoRepository.findById(id);
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Grupo save(Grupo entity) throws Exception {
		// 1. validar que el usuario exista
		// 2. Validar que el rol -> implica las tablas roles; rolproyecto
		if (entity == null) {
			throw new Exception("error en peticion");
		} else {
			return grupoRepository.save(entity);
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Grupo update(Grupo entity) throws Exception {
		if (entity == null) {
			throw new Exception("error en peticion");
		}
		return grupoRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		if (grupoRepository.existsById(id)) {

			grupoRepository.deleteById(id);

		} else {
			throw new Exception("Erro: No se reconocio el identificador de grupo");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {

		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Grupo entity) throws Exception {

	}

	@Override
	public void validate(Grupo entity) throws Exception {

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Grupo saveAndrol(GrupoDTO entity, Integer idrol, String idNombrerol) throws Exception {
		// 1. validar que el usuario exista
		// 2. Validar que el rol -> implica las tablas roles; rolproyecto
		// rolesRepository
		// rolProyectoRepository
		log.info("saveAndrol(): GrupoServiceImpl.java");
		if (idrol != 0) {
			// rol redefinido
			// log.info(idrol.toString());
			RolProyecto rolProyecto = new RolProyecto();
			Roles newRol = new Roles();
			Grupo matricula = new Grupo();
			Proyecto proyecto = new Proyecto();
			Usuario usuario = new Usuario();

			if (!proyectoRepository.existsById(entity.getIdproyecto())) {
				throw new IllegalArgumentException("Proyecto no identificado");
			}
			if (!rolesRepository.existsById(idrol)) {
				throw new IllegalArgumentException("EL ROL NO EXISTE");
			}
			// guardando el Nuevo Rol
			newRol.setIdrol(idrol);

			// agregar informacion base para la matricula

			proyecto.setIdproyecto(entity.getIdproyecto());
			usuario.setEmail(entity.getEmail());

			// agregar Al grupo de Trabajo x Proyecto
			matricula.setProyectos(proyecto);
			matricula.setUsuarios(usuario);

			matricula = grupoRepository.save(matricula);
			// agregar el rol que cumple la persona en el grupo de trabajo

			rolProyecto.setRoles(newRol);
			rolProyecto.setGrupo(matricula);

			rolProyectoRepository.save(rolProyecto);

			return matricula;

		} else {
			// rol nuevo
			RolProyecto rolProyecto = new RolProyecto();
			Roles newRol = new Roles();
			Grupo matricula = new Grupo();
			Proyecto proyecto = new Proyecto();
			Usuario usuario = new Usuario();

			if (!proyectoRepository.existsById(entity.getIdproyecto())) {
				throw new IllegalArgumentException("Proyecto no identificado");
			}
			idNombrerol = idNombrerol.replace(" ", "");
			if (grupoRepository.validarRol(idNombrerol)) {
				throw new IllegalArgumentException("EL ROL YA EXISTE");
			}
			// guardando el Nuevo Rol
			newRol.setNombrerol(idNombrerol);

			newRol = rolesRepository.save(newRol);

			// agregar informacion base para la matricula

			proyecto.setIdproyecto(entity.getIdproyecto());
			usuario.setEmail(entity.getEmail());

			// agregar Al grupo de Trabajo x Proyecto
			matricula.setProyectos(proyecto);
			matricula.setUsuarios(usuario);

			matricula = grupoRepository.save(matricula);
			// agregar el rol que cumple la persona en el grupo de trabajo

			rolProyecto.setRoles(newRol);
			rolProyecto.setGrupo(matricula);

			rolProyectoRepository.save(rolProyecto);

			return matricula;
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String CrearfaseConResponsables(CrearfaseConResponsablesDTO crearfaseConResponsablesDTO) throws Exception {
		// Pasos para el metodo
		// 1. crerar la fase
		// 2. crear el subGrupo con los usuarios llamados
		// 3. crear la Reunión

		FaseProyecto faseObjeto = new FaseProyecto();
		Reunion reunionObjeto = new Reunion();

		faseObjeto.setIdtipofase(crearfaseConResponsablesDTO.getIdtipofase());

		faseObjeto.setDescripcionfase(crearfaseConResponsablesDTO.getDescripcionfase());

		Date fecha = new SimpleDateFormat("yyyy/MM/dd").parse(crearfaseConResponsablesDTO.getTiempoinicio());
		faseObjeto.setTiempoinicio(fecha);

		fecha = new SimpleDateFormat("yyyy/MM/dd").parse(crearfaseConResponsablesDTO.getTiempofin());
		faseObjeto.setTiempofin(fecha);
		// GUARDAR LA FASE PARA EXTRAER EL ID Y GRABAR LOS SUBGRUPOS Y LAS REUNIONES
		try {
			faseObjeto = faseProyectoRepository.save(faseObjeto);

		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}

		// funcion para crear los subGrupos de trabajo
		CrearSubgrupo(crearfaseConResponsablesDTO.getIdresponsable(), faseObjeto);

		Proyecto proyectoObjeto = new Proyecto();

		reunionObjeto.setDescripcionreunion(crearfaseConResponsablesDTO.getDescripcionreunion());
		reunionObjeto.setNombrereunion(crearfaseConResponsablesDTO.getNombrereunion());

		proyectoObjeto.setIdproyecto(crearfaseConResponsablesDTO.getIdproyecto());

		reunionObjeto.setProyectos(proyectoObjeto);
		reunionObjeto.setFaseproyecto(faseObjeto);

		reunionObjeto = reunionRepository.save(reunionObjeto);

		log.info("SE GRABO LA NUEVA REUNION Y SU ID ES: " + reunionObjeto.getIdreuniones().toString());

		return "{\"success\":true,\"status\":ok, \"message\": Datos Guardados }";
	}

	@SuppressWarnings("unused")
	private void CrearSubgrupo(List<idresponsable> idUsuarioGrupo, FaseProyecto fase) throws Exception {
		SubGrupo subgrupo = new SubGrupo();
		Grupo grupoObjeto = new Grupo();

		for (idresponsable id : idUsuarioGrupo) {

			subgrupo.setFaseproyecto(fase);

			grupoObjeto.setIdgrupo(id.getId());

			subgrupo.setGrupo(grupoObjeto);

			try {
				subGrupoRepository.save(subgrupo);
				subgrupo = new SubGrupo();
				grupoObjeto = new Grupo();

			} catch (InvalidResultSetAccessException e) {
				throw new RuntimeException(e);
			} catch (DataAccessException e) {
				throw new RuntimeException(e);
			}

		}

	}

	@Override
	@Transactional(readOnly = true)
	public List<RolesDTO> rolesDisponibles() throws Exception {
		List<RolesDTO> DTOList = new ArrayList<RolesDTO>();

		for (Roles rol : rolesRepository.findAll()) {
			RolesDTO DTO = new RolesDTO();
			DTO.setIdrol(rol.getIdrol());
			DTO.setNombrerol(rol.getNombrerol());
			DTOList.add(DTO);
			DTO = new RolesDTO();
		}

		return DTOList;
	}

	@Override
	@Transactional(readOnly = true)
	public List<GrupoDTO> grupoDeTrabajo(Integer idProyecto) throws Exception {
		List<GrupoDTO> DTOList = new ArrayList<GrupoDTO>();
		log.info("grupoDeTrabajo() : Services ");
		for (Grupo grupo : grupoRepository.grupoDeTrabajo(idProyecto)) {
			GrupoDTO DTO = new GrupoDTO();
			// Optional<RolProyecto> rol =
			// grupoRepository.rolGrupoDeTrabajo(grupo.getIdgrupo());
			RolProyecto rol = rolProyectoRepository.rolGrupoDeTrabajo(grupo.getIdgrupo());

			DTO.setIdgrupo(grupo.getIdgrupo());
			DTO.setIdproyecto(grupo.getProyectos().getIdproyecto());
			DTO.setEmail(grupo.getUsuarios().getEmail());

			DTO.setIdrol(rol.getRoles().getIdrol());
			DTO.setIdNombrerol(rol.getRoles().getNombrerol());
			DTOList.add(DTO);
			DTO = new GrupoDTO();
		}
		return DTOList;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ControlFasesDTO> controlPorFases(String Usuario) throws Exception {
		List<ControlFasesDTO> DTOList = new ArrayList<ControlFasesDTO>();
		// Entidades necesarias

		// List<Reunion> ListaReuniones = new ArrayList<>();

		try {
			// grupoRepository.ControlFasesQuery(Usuario);

			List<Proyecto> proyecto = proyectoRepository.finByEmail(Usuario);
			Date date = new Date();

			Proyecto proyectoData = new Proyecto();
			if (proyecto.size() != 0 || proyecto != null) {
				Integer id = 0;
				for (Proyecto xxx : proyecto) {
					proyectoData = xxx;
					id = xxx.getIdproyecto();
				}
				if (id == 0 || id < 1 || id == null) {
					throw new IllegalArgumentException("No se encontro el proyecto");
				} else {
					// Reuniones
					for (Reunion reunion : reunionRepository.reunionPorIdProyecto(id)) {
						// fases del proyecto
						Optional<FaseProyecto> fase = faseProyectoRepository
								.findById(reunion.getFaseproyecto().getIdfase());
						if (fase.isPresent()) {
							// Tipo de la fase
							Optional<tipofases> tipoFases = tipoFasesRepository.findById(fase.get().getIdtipofase());
							if (tipoFases.isPresent()) {
								ControlFasesDTO DTO = new ControlFasesDTO();
								DTO.setNombreProyecto(proyectoData.getNombre());
								DTO.setDescripcionProyecto(proyectoData.getDescripcion());
								DTO.setNombreReunion(reunion.getNombrereunion());
								DTO.setDescripcionReunion(reunion.getDescripcionreunion());
								DTO.setDescripcionFase(fase.get().getDescripcionfase());
								// Date fecha = new
								// SimpleDateFormat("yyyy/MM/dd").parse(fase.get().getTiempoinicio());
								// faseObjeto.setTiempoinicio(fecha);

								DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

								if (fase.get().getDescripcionfase().compareTo(dateFormat.format(date)) > 0) {
									DTO.setEstado("Terminado");

								} else {
									DTO.setEstado("En proceso");

								}
								// log.info("\n \n ");

								String date_s = fase.get().getTiempoinicio().toString();
								SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								Date date2 = dt.parse(date_s);
								SimpleDateFormat dt1 = new SimpleDateFormat("yyyy/MM/dd");

								/*
								 * // log.info("-> tipo ->"+((Object)fase.get().getTiempoinicio()).getClass().
								 * getSimpleName()); // log.info("Convertido ->"+fase.get().getTiempoinicio() );
								 * // Date dateConverte = new
								 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(fase.get().getTiempoinicio().
								 * toString()); // log.info("Convertido ->"+dateConverte.toString()); //
								 * log.info("Tipo Convertido ->"+((Object)dateConverte
								 * ).getClass().getSimpleName()); // dateConverte = new
								 * SimpleDateFormat("yyyy-MM-dd").parse(fase.get().getTiempofin().toString());
								 */

								DTO.setInicio((String) dt1.format(date2));

								// String date_s = fase.get().getTiempoinicio().toString();
								date_s = fase.get().getTiempofin().toString();
								dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								date2 = dt.parse(date_s);
								dt1 = new SimpleDateFormat("yyyy/MM/dd");
								// log.info("->-> Aca _-> " + dt1.format(date2));

								DTO.setFin((String) dt1.format(date2));

								DTO.setNombre(tipoFases.get().getNombrefase());
								DTO.setIdFase(fase.get().getIdfase());

								DTOList.add(DTO);

							}

						}
					}

				}

				// fase
				//// tipoFases

			} else {
				throw new IllegalArgumentException("No se encontro el proyecto");

			}
			//
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}

		if (DTOList.isEmpty()) {
			throw new IllegalArgumentException("Error en Listado ");
		}
		/*
		 * for (ControlFasesDTO DTO : grupoRepository.ControlFasesQuery(Usuario)) {
		 * log.info(DTO.getDescripcionProyecto());
		 * 
		 * 
		 * }
		 */
		// throw new IllegalArgumentException("Proyecto no identificado");
		return DTOList;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String elimiarUsuarioMatriculado(String Usuario, Integer idProyecto) throws Exception {
		Boolean IS_EMAIL = false;
		if (Usuario != null || Usuario != "") {
			Pattern p = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");

			Matcher m = p.matcher(Usuario);

			IS_EMAIL = m.find();
		}
		if (IS_EMAIL) {
			// 1. Buscar en subGrupos
			// 2. Borrar RolProyecto (Es el rol o reoles que desempeña el usuario durante un
			// proyecto
			try {
				grupoRepository.elimiarUsuarioRol(Usuario, idProyecto);

				grupoRepository.elimiarUsuarioSubGrupo(Usuario, idProyecto);

				// 2. Buscar en Grupos
				grupoRepository.elimiarUsuarioMatriculado(Usuario, idProyecto);

			} catch (Exception e) {
				throw new IllegalArgumentException("{\"success\":fasle,\"status\":Error, \"message\":" + e + " }");
			}
			return "{\"success\":true,\"status\":Ok, \"message\": Se elimino por completo el usuario " + Usuario
					+ " del proyecto }";
		}

		return "{\"success\":fasle,\"status\":Error, \"message\": No se encontro el ususario }";

	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuariosDTO> verGrupoDeTrabajoPorReunion() throws Exception {
		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public String elimiarUsuarioPorRolenProyecto(String Usuario, Integer idProyecto, String Rol) throws Exception {
		try {
			Boolean IS_EMAIL = false;
			if (Usuario != null || Usuario != "") {
				Pattern p = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");

				Matcher m = p.matcher(Usuario);

				IS_EMAIL = m.find();
			}
			if (IS_EMAIL) {
				if (Rol != null || Rol != "" && idProyecto != null || idProyecto > 0) {

					grupoRepository.elimiarUsuarioMatriculado(Usuario, idProyecto);// , Rol);

					return "{\"success\":OK,\"status\":true, \"message\": Se elimino el usuario " + Usuario
							+ " del proyecto }";
				}
				return "{\"success\":false,\"status\":Error, \"message\": Error en datos }";

			}
			return "{\"success\":false,\"status\":Error, \"message\": No se encontro el ususario }";

		} catch (Exception e) {
			throw new IllegalArgumentException("{\"success\":fasle,\"status\":Error, \"message\":" + e + " }");
		}

	}

	@Override
	public List<ResponsablesDTO> responsablesEnFaseoReunion(Integer idProyecto) throws Exception {
		if (idProyecto != null || idProyecto > 0) {
			List<ResponsablesDTO> DTO = new ArrayList<ResponsablesDTO>();
			try {
				for(Grupo grupo :grupoRepository.responsablesEnFaseoReunion(idProyecto)) {
					ResponsablesDTO dto = new ResponsablesDTO();
					
					
					for (Integer i = 0 ; i <= grupo.getRolProyectos().size()-1;i ++) {
						dto.setNombrerol(grupo.getRolProyectos().get(i).getRoles().getNombrerol() );
					}
					
					for (Integer i = 0 ; i <= grupo.getSubGrupos().size()-1;i ++) {
						dto.setIdfase(grupo.getSubGrupos().get(i).getFaseproyecto().getIdfase());
					}
					//dto.setIdfase(grupo.getProyectos().getReuniones().get);
					for (Integer i = 0 ; i <= grupo.getSubGrupos().size()-1;i ++) {
						dto.setId_sub_grupo(grupo.getSubGrupos().get(i).getId_sub_grupo());
					}
					//dto.setId_sub_grupo(grupo.getSubGrupos().);
					dto.setIdgrupo(grupo.getIdgrupo());
					 dto.setEmail(grupo.getUsuarios().getEmail());
					DTO.add(dto);
				} 
			} catch (Exception e) {
				
				throw new IllegalArgumentException(e);

			}
			
			if (DTO.isEmpty()) {
				throw new IllegalArgumentException(
						"{\"success\":false,\"status\":Error, \"message\": No se encontro el Identificador de la Fase }");
			} else {
				return DTO;
			}

		}
		throw new IllegalArgumentException(
				"{\"success\":false,\"status\":Error, \"message\": No se encontro el Identificador de la Fase }");
	}
}
/*
 * DTO.setIdgrupo(grupo.getIdgrupo());
 * DTO.setId_sub_grupo(grupo.getId_sub_grupo());
 * DTO.setIdproyecto(grupo.getIdproyecto()); DTO.setEmail(grupo.getEmail());
 * DTO.setIdrol(grupo.getIdrol()); DTO.setIdNombrerol(grupo.getIdNombrerol());
 */
