package com.tesis.v1.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import com.tesis.v1.domain.notificaciones;
import com.tesis.v1.domain.tipofases;
import com.tesis.v1.dto.ControlFasesDTO;
import com.tesis.v1.dto.CrearfaseConResponsablesDTO;
import com.tesis.v1.dto.FaseProyectoDTO;
import com.tesis.v1.dto.GrupoDTO;
import com.tesis.v1.dto.ProyectoDTO;
import com.tesis.v1.dto.ResponsablesDTO;
import com.tesis.v1.dto.ReunionesDTO;
import com.tesis.v1.dto.RolesDTO;
import com.tesis.v1.dto.RolproyectoDTO;
import com.tesis.v1.dto.UsuariosDTO;
import com.tesis.v1.dto.idresponsable;
import com.tesis.v1.dto.controlFasesDTOs.ControlFase_01DTO;
import com.tesis.v1.dto.controlFasesDTOs.ControlFase_02DTO;
import com.tesis.v1.dto.controlFasesDTOs.ControlFase_03DTO;
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

	@Autowired
	NotificacionesService notificacionesService;

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
			matricula.setEstado(false);

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
		try {
			// *****************************************************************
			// GUARDAR LA FASE PARA EXTRAER EL ID Y GRABAR LOS SUBGRUPOS Y LAS REUNIONES
			// *****************************************************************
			faseObjeto = faseProyectoRepository.save(faseObjeto);

		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}

		// ***************************************************************************
		// ************** funcion para crear los subGrupos de trabajo **************
		// ***************************************************************************
		CrearSubgrupo(crearfaseConResponsablesDTO.getIdresponsable(), faseObjeto,
				crearfaseConResponsablesDTO.getIdproyecto(), crearfaseConResponsablesDTO.getIdtipofase());

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
	private void CrearSubgrupo(List<idresponsable> idUsuarioGrupo, FaseProyecto fase, Integer IdProyecto,
			Integer idtipofase) throws Exception {
		SubGrupo subgrupo = new SubGrupo();
		Grupo grupoObjeto = new Grupo();
		// *****************************************************************
		// Iterar lista de Identificadores de usuario en grupo

		for (idresponsable id : idUsuarioGrupo) {

			subgrupo.setFaseproyecto(fase);

			grupoObjeto.setIdgrupo(id.getId());

			subgrupo.setGrupo(grupoObjeto);
			subgrupo.setEstado(false);

			try {
				// con el id de grupo en cual
				subgrupo = subGrupoRepository.save(subgrupo);

			} catch (InvalidResultSetAccessException e) {
				throw new RuntimeException(e);
			} catch (DataAccessException e) {
				throw new RuntimeException(e);
			}
			try {

				// *****************************************************************
				// Buscar a los usuario agregados para crar la notificacio
				Optional<Grupo> tmpGrupo = grupoRepository.findById(subgrupo.getGrupo().getIdgrupo());
				Optional<Proyecto> tmpProyecto = proyectoRepository.findById(IdProyecto);
				Optional<tipofases> tmpTipoFase = tipoFasesRepository.findById(idtipofase);

				notificaciones Notificacion = new notificaciones();
				Notificacion.setEmisor(tmpProyecto.get().getAdmin());
				Notificacion.setReceptor(tmpGrupo.get().getUsuarios().getEmail());
				Notificacion.setMensaje("Usted  ha sido agregado por el usuario: " + tmpProyecto.get().getAdmin()
						+ " a la fase del proyecto: " + tmpProyecto.get().getNombre() + ",  llamada:  "
						+ tmpTipoFase.get().getNombrefase());
				Notificacion.setEstado(false);
				notificacionesService.save(Notificacion);

				subgrupo = new SubGrupo();
				grupoObjeto = new Grupo();

			} catch (InvalidResultSetAccessException e) {
				throw new RuntimeException(e);
			} catch (DataAccessException e) {
				throw new RuntimeException(e);
			} catch (Exception e) {
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
	public List<ControlFase_01DTO> controlPorFases(String Usuario) throws Exception {
		// Se crea la lista que va a retornarse
		// List<ControlFasesDTO> DTOList = new ArrayList<ControlFasesDTO>();
		List<ControlFase_01DTO> DTOList = new ArrayList<ControlFase_01DTO>();
		

		try {
			// grupoRepository.ControlFasesQuery(Usuario);

			List<Proyecto> proyecto = proyectoRepository.finByEmail(Usuario);

			Date date = new Date();
			Proyecto proyectoData = new Proyecto();

			Integer id = 0;
			for (Proyecto xxx : proyecto) {
				// Proyectos
				List<ProyectoDTO> proyectosList = new ArrayList<ProyectoDTO>();
				;
				// Reuniones
				// List<ReunionesDTO> reunionesList = new ArrayList<ReunionesDTO>();
				List<ControlFase_02DTO> reunionesList = new ArrayList<ControlFase_02DTO>();
				
				// Faseproyecto
				// List<FaseProyectoDTO> fasesList = new ArrayList<FaseProyectoDTO>();
				List<ControlFase_03DTO> fasesList = new ArrayList<ControlFase_03DTO>();
				

				//ControlFasesDTO DTOMaestro = new ControlFasesDTO();
				ControlFase_01DTO DTOMaestro = new ControlFase_01DTO();
				proyectoData = xxx;
				id = proyectoData.getIdproyecto();

				// Logica Pesada
				if (id == 0 || id < 1 || id == null) {
					throw new IllegalArgumentException("No se encontro el proyecto");
				}
				// Proyectos
				// ProyectoDTO proyectosDto = new ProyectoDTO();
				// 				proyectosDto.setNombre(proyectoData.getNombre());
				// proyectosDto.setDescripcion(proyectoData.getDescripcion());
				// proyectosDto.setIdproyecto(proyectoData.getIdproyecto());

				// proyectosList.add(proyectosDto);
				DTOMaestro.setNombre(proyectoData.getNombre());
				DTOMaestro.setDescripcion(proyectoData.getDescripcion());
				DTOMaestro.setIdproyecto(proyectoData.getIdproyecto());
				DTOMaestro.setAdmin(proyectoData.getAdmin());
				DTOMaestro.setTipo_id(proyectoData.getTipoProyecto().getTipo_id());


				for (Reunion reunion : proyectoData.getReuniones()) {
					reunionesList = new ArrayList<ControlFase_02DTO>();
					fasesList = new ArrayList<ControlFase_03DTO>();
					ControlFase_02DTO dto = new ControlFase_02DTO();
					ControlFase_03DTO dto_2 = new ControlFase_03DTO();

					// fases
					dto_2.setDescripcionfase(reunion.getFaseproyecto().getDescripcionfase());
					dto_2.setIdfase(reunion.getFaseproyecto().getIdfase());
					// dto_2.setNombrefase(reunion.getFaseproyecto().gett);
					dto_2.setTiempoinicio(reunion.getFaseproyecto().getTiempoinicio());
					dto_2.setTiempofin(reunion.getFaseproyecto().getTiempofin());
					Optional<tipofases> tipoTmp = tipoFasesRepository.findById(reunion.getFaseproyecto().getIdtipofase());
					
					dto_2.setNombrefase(tipoTmp.get().getNombrefase());
					fasesList.add(dto_2);
					
					// reuniones
					dto.setNombrereunion(reunion.getNombrereunion());
					dto.setDescripcionreunion(reunion.getDescripcionreunion());
					dto.setIdreuniones(reunion.getIdreuniones());
					dto.setIdproyecto(reunion.getProyectos().getIdproyecto());
					dto.setIdfase(reunion.getFaseproyecto().getIdfase());
					dto.setFases(fasesList);
					
					
					reunionesList.add(dto);

				}
				//DTOMaestro.setFases(fasesList);
				//DTOMaestro.setProyectos(proyectosList);
				DTOMaestro.setReuniones(reunionesList);
				DTOList.add(DTOMaestro);

			}

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
	@Transactional(readOnly = true, noRollbackFor = Exception.class)
	public List<ControlFasesDTO> controlParticipacionesPorFasesNOHABILITADO(Integer idProyecto, String Usuario) throws Exception {
		List<ControlFasesDTO> DTOList = new ArrayList<ControlFasesDTO>();
		try {
			//grupoRepository.obtenerDatosDeParticipaicon(idProyecto, Usuario);
			List<Grupo> grupoList  = new ArrayList<Grupo>();
			if (grupoRepository.obtenerDatosDeParticipaicon(idProyecto, Usuario).size() == 0 || grupoRepository.obtenerDatosDeParticipaicon(idProyecto, Usuario).isEmpty()) {

			} else {
				for (Grupo grupo : grupoRepository.obtenerDatosDeParticipaicon(idProyecto, Usuario)) {
					// Variables
					ControlFasesDTO DTOMaestro = new ControlFasesDTO();
					// Proyectos
					List<ProyectoDTO> proyectosList = new ArrayList<ProyectoDTO>();
					ProyectoDTO proyectosTMP = new ProyectoDTO();
					// Reuniones
					List<ReunionesDTO> reunionesList = new ArrayList<ReunionesDTO>();
					
					// Faseproyecto
					List<FaseProyectoDTO> fasesList = new ArrayList<FaseProyectoDTO>();
					
					
					
					//SubGrupo subgrupoTMP = subGrupoRepository.obtenerDatosDeParticipaiconSubgrupo(grupo.getIdgrupo());
					
					// Set #1
					proyectosTMP.setIdproyecto(grupo.getProyectos().getIdproyecto());
					proyectosTMP.setNombre(grupo.getProyectos().getNombre());
					proyectosTMP.setDescripcion(grupo.getProyectos().getDescripcion());
					proyectosTMP.setAdmin(grupo.getProyectos().getAdmin());
					proyectosTMP.setTipo_id(grupo.getProyectos().getTipoProyecto().getTipo_id());
					proyectosList.add(proyectosTMP);
					DTOMaestro.setProyectos(proyectosList);
					
					// Reuniones por proyecto
					Proyecto Proyecto = grupo.getProyectos();
					for(Reunion reunion : Proyecto.getReuniones() ) {
						ReunionesDTO reunionesTMP = new ReunionesDTO();
						FaseProyectoDTO fasesTMP = new FaseProyectoDTO();
				
						
						if(grupoRepository.responsablesEnFaseoReunionValidacion(reunion.getFaseproyecto().getIdfase(),
								Usuario)) {
							
							reunionesTMP.setIdreuniones(reunion.getIdreuniones());
							reunionesTMP.setNombrereunion(reunion.getNombrereunion());
							reunionesTMP.setDescripcionreunion(reunion.getDescripcionreunion());
							reunionesTMP.setIdproyecto(reunion.getProyectos().getIdproyecto());
							reunionesTMP.setIdfase(reunion.getFaseproyecto().getIdfase());
							reunionesList.add(reunionesTMP);
							
							fasesTMP.setIdfase(reunion.getFaseproyecto().getIdfase());
							Optional<tipofases> tipoTmp = tipoFasesRepository
									.findById(reunion.getFaseproyecto().getIdtipofase());
							fasesTMP.setNombrefase(tipoTmp.get().getNombrefase());
							fasesTMP.setDescripcionfase(reunion.getFaseproyecto().getDescripcionfase());
							fasesTMP.setTiempoinicio(reunion.getFaseproyecto().getTiempoinicio());
							fasesTMP.setTiempofin(reunion.getFaseproyecto().getTiempofin());
							
							fasesList.add(fasesTMP);
						}			
						DTOMaestro.setFases(fasesList);
						DTOMaestro.setReuniones(reunionesList);
						
						
					}
					DTOList.add(DTOMaestro);
				// Final For
				}

				return DTOList;
			// final Else
			}

		} catch (Exception e) {
			log.info(e.toString());
		}

		return null;
	}
	
	// ControlFase_01DTO
	

	@Override
	@Transactional(readOnly = true, noRollbackFor = Exception.class)
	public List<ControlFase_01DTO> controlParticipacionesPorFases(Integer idProyecto, String Usuario) throws Exception {
		List<ControlFase_01DTO> DTOList = new ArrayList<ControlFase_01DTO>();
		try {
			//grupoRepository.obtenerDatosDeParticipaicon(idProyecto, Usuario);
			List<Grupo> grupoList  = new ArrayList<Grupo>();
			if (grupoRepository.obtenerDatosDeParticipaicon(idProyecto, Usuario).size() == 0 || grupoRepository.obtenerDatosDeParticipaicon(idProyecto, Usuario).isEmpty()) {

			} else {
				for (Grupo grupo : grupoRepository.obtenerDatosDeParticipaicon(idProyecto, Usuario)) {
					// 
					ControlFase_01DTO DTOMaestro = new ControlFase_01DTO();
					// Proyectos
					// List<ProyectoDTO> proyectosList = new ArrayList<ProyectoDTO>();
					// ProyectoDTO proyectosTMP = new ProyectoDTO();
					// Reuniones
					List<ControlFase_02DTO> reunionesList = new ArrayList<ControlFase_02DTO>();
					
					// Faseproyecto -> Control de Fases
					List<ControlFase_03DTO> fasesList = new ArrayList<ControlFase_03DTO>();
					
					
					
					//Guardamos la info del proyecto 
					
					// Set #1
					DTOMaestro.setIdproyecto(grupo.getProyectos().getIdproyecto());
					DTOMaestro.setNombre(grupo.getProyectos().getNombre());
					DTOMaestro.setDescripcion(grupo.getProyectos().getDescripcion());
					DTOMaestro.setAdmin(grupo.getProyectos().getAdmin());
					DTOMaestro.setTipo_id(grupo.getProyectos().getTipoProyecto().getTipo_id());
					// proyectosList.add(proyectosTMP);
					// DTOMaestro.setProyectos(proyectosList);
					
					// Reuniones por proyecto -> extraemos la info bien mela
					Proyecto Proyecto = grupo.getProyectos();
					List<Reunion>  reunionLista = Proyecto.getReuniones();
					for(Reunion reunion :  reunionLista) {
						log.info("");
						log.info("Entramos a ITERAR EN TODAS LAS REUNIONES, BUSCANDO EN CUAL HACE MATCH");
						// tmporales pora cada iteración
						ControlFase_02DTO reunionesTMP = new ControlFase_02DTO();
						ControlFase_03DTO fasesTMP = new ControlFase_03DTO();
						
						// Condidion para saber si el ususario tiene actividades asignadas es decir si fase del proyecto esta includi el usuario
						if(grupoRepository.responsablesEnFaseoReunionValidacion(reunion.getFaseproyecto().getIdfase(),
								Usuario)) {
						log.info("SI MACTH");
							
							log.info("CONDICION PARA GRABAR LAS FASER Y REUNION");
							fasesTMP.setIdfase(reunion.getFaseproyecto().getIdfase());
							
							Optional<tipofases> tipoTmp = tipoFasesRepository.findById(reunion.getFaseproyecto().getIdtipofase());
							log.info(tipoTmp.get().getNombrefase().toString());
							
														
							log.info("condion: EL ID DE LA FASE, DEBE REFLEJARSE EN GRUPO Y FASEPROYECTO");
							
						
							
							fasesTMP.setNombrefase(tipoTmp.get().getNombrefase());
							fasesTMP.setDescripcionfase(reunion.getFaseproyecto().getDescripcionfase());
							fasesTMP.setTiempoinicio(reunion.getFaseproyecto().getTiempoinicio());
							fasesTMP.setTiempofin(reunion.getFaseproyecto().getTiempofin());
							
							fasesList.add(fasesTMP);
							
							reunionesTMP.setIdreuniones(reunion.getIdreuniones());
							reunionesTMP.setNombrereunion(reunion.getNombrereunion());
							reunionesTMP.setDescripcionreunion(reunion.getDescripcionreunion());
							reunionesTMP.setIdproyecto(reunion.getProyectos().getIdproyecto());
							reunionesTMP.setIdfase(reunion.getFaseproyecto().getIdfase());
							
							
							reunionesTMP.setFases(fasesList);
							fasesList = new ArrayList<ControlFase_03DTO>();
							reunionesList.add(reunionesTMP);
							
						
						}			
						DTOMaestro.setReuniones(reunionesList);
						
						
					}
					DTOList.add(DTOMaestro);
				// Final For
				}

				return DTOList;
			// final Else
			}

		} catch (Exception e) {
			log.info(e.toString());
		}

		return null;
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
				for (Grupo grupo : grupoRepository.responsablesEnFaseoReunion(idProyecto)) {
					ResponsablesDTO dto = new ResponsablesDTO();

					for (Integer i = 0; i <= grupo.getRolProyectos().size() - 1; i++) {
						dto.setNombrerol(grupo.getRolProyectos().get(i).getRoles().getNombrerol());
					}

					for (Integer i = 0; i <= grupo.getSubGrupos().size() - 1; i++) {
						dto.setIdfase(grupo.getSubGrupos().get(i).getFaseproyecto().getIdfase());
					}
					// dto.setIdfase(grupo.getProyectos().getReuniones().get);
					for (Integer i = 0; i <= grupo.getSubGrupos().size() - 1; i++) {
						dto.setId_sub_grupo(grupo.getSubGrupos().get(i).getId_sub_grupo());
					}
					// dto.setId_sub_grupo(grupo.getSubGrupos().);
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

	@Override
	@Transactional(readOnly = true)
	public List<GrupoDTO> buscarParticipaciones(String Usuario) throws Exception {
		List<GrupoDTO> DTOList = new ArrayList<>();
		for (Grupo grupo : grupoRepository.buscarParticipaciones(Usuario)) {
			GrupoDTO DTO = new GrupoDTO();
			DTO.setId_sub_grupo(0);
			DTO.setIdgrupo(grupo.getIdgrupo());
			DTO.setIdproyecto(grupo.getProyectos().getIdproyecto());
			DTO.setEmail(grupo.getUsuarios().getEmail()); // Se puede sacar el nombre del ususario más no el correo,
															// puede ser mas util el nombre que el correo
			DTO.setEstado(grupo.getEstado());
			DTOList.add(DTO);
		}

		return DTOList;
	}

}
/*
 * DTO.setIdgrupo(grupo.getIdgrupo());
 * DTO.setId_sub_grupo(grupo.getId_sub_grupo());
 * DTO.setIdproyecto(grupo.getIdproyecto()); DTO.setEmail(grupo.getEmail());
 * DTO.setIdrol(grupo.getIdrol()); DTO.setIdNombrerol(grupo.getIdNombrerol());
 */
