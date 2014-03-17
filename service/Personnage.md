# service: Personnage
## use: Object
## types : String,int,boolean 
## observators:
	- const nom: [Personnage] -> String
	- const largeur: [Personnage] -> int
	- const hauteur: [Personnage] -> int
	- const profonder: [Personnage] -> int
	- const force: [Personnage] -> int
	- hp:[Personnage] -> int
	- money:[Personnage] -> int
	- alive:[Personnage] -> boolean
	- equiped:[Personnage] -> boolean
	- object?:[Personnage] -> Object
	
##Constructors:
	init: String * int * int * int * int -> Personnage
	 pre init(nom,largeur,hauter,profondeur,force) require nom != "" AND force > 0
	Operators:
		depotsHP: [Personnage] * int -> Personnage
			pre depotsHP(P,s) require s > 0 & alive(P)
		retraitHP: [Personnage] * int -> Personnage
			pre retraitHP(P,s) require s> 0 & alive(P)
		depotMoney: [Personnage] * int -> Personnage
			pre depotMoney(P,s) require s>0 & alive(P)
		retraitMoney: [Personnage] * int -> Personnage
			pre depoitMoney(P,s) require s>0 & money(p)-s >= 0 & alive(p)
		jeter: [Personnage] -> Personnage
			pre jeter(p) require !equiped(p)
		rammaser: [Personnage] * Object -> Personnage
##Observation:
	[invariant]
		alive(p) min= hp(p) > 0
		equiped(p) min= object?(p) != null
	[init]
		nom(init(n,l,h,p,f))=n
		larguer(init(n,l,h,p,f))=l
		hauter(init(n,l,h,p,f))=h
		profonder(init(n,l,h,p,f))=p
		force(init(n,l,h,p,f))=f
		hp(init(n,l,h,p,f))=100
		money(init(n,l,h,p,f))=0
		equiped(init(n,l,h,p,f))=false
		object?(init(n,l,h,p,f))=null
	[depotsHP]
		hp(depotsHP(p,s))=hp(p)+s
	[retraitHP]
		hp(retraitHP(p,s))=hp(p)-s
	[depotMoney]
		money(depotMoney(p,s))=money(p)+s
	[retraitMoney]
		money(retraitMoney(p,s))=money(p)-s
	[jeter]
		equiped(jeter(p))=false
	[rammaser]
		equiped(rammaser(p,o))=true
		object?(rammaser(p,o))=o


	