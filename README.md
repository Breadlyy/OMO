# Omo Semestralka



## Smart home

Goal of our project is to simulate house with electric stuff and sensor. 
There are functional requirements done:
F1.	Entity se kterými pracujeme je dům, okno (+ venkovní žaluzie), patro v domu, senzor, zařízení (=spotřebič), osoba, auto, kolo, domácí zvíře jiného než hospodářského typu, plus libovolné další entity

F2.	Jednotlivá zařízení v domu mají API na ovládání. Zařízení mají stav, který lze měnit pomocí API na jeho ovládání. Akce z API jsou použitelné podle stavu zařízení. Vybraná zařízení mohou mít i obsah - lednice má jídlo, CD přehrávač má CD.

F3.	Spotřebiče mají svojí spotřebu v aktivním stavu, idle stavu, vypnutém stavu

F4.	Jednotlivá zařízení mají API na sběr dat o tomto zařízení. O zařízeních sbíráme data jako spotřeba elektřiny, plynu, vody a funkčnost (klesá s časem)

F5.	Jednotlivé osoby a zvířata mohou provádět aktivity(akce), které mají nějaký efekt na zařízení nebo jinou osobu (tata může otevřít okno)

F6.	Jednotlivá zařízení a osoby se v každém okamžiku vyskytují v jedné místnosti (pokud nesportují) a náhodně generují eventy (eventem může být důležitá informace) d

F7.	Eventy jsou přebírány a odbavovány vhodnou osobou (osobami) nebo zařízením (zařízeními). Např.:
        
        ○	čidlo na vítr (vítr) => zavření oken
        
        ○	jistič (výpadek elektřiny) => vypnutí všech elektrických spotřebičů
        
        ○	čidlo na vlhkost (prasklá trubka na vodu) => vypnutí vody
        
        ○   Miminko potřebuje spat => táta se skrývá
        
        ○	Zařízení přestalo fungovat => tata opraví 
        
        ○	V lednici došlo jídlo => tata jde po jidlo

F8.	Vygenerování reportů:
        ○	HouseConfigurationReport: veškerá konfigurační data domu zachovávající hieararchii - dům -> patro -> místnost -> okno -> žaluzie atd. Plus jací jsou obyvatelé domu.
        

F9.	Při rozbití zařízení tata opravuje zařizení. Trvá to vice času

F10.	Rodina je aktivní a volný čas tráví buď peči o děti, opravovaním zařizení, nahodnou interakci s zařizením nebo sportem. Když není volné zařízení nebo sportovní náčiní, tak osoba nesportuje.
  

## Interakce

Při spouštění programů otevře se JFrame. On bude poslouchat na tlačitka a volat Eventy

1 - wind

2 - fire

3 - flood

4 - short circuit

## Start

Program je načitan pomoci třidy Parser z json filu

## Patterns

Singleton: můžeme vytvářet pouze 1 home.
Factory: StuffFactory je factory pro vytváření Stuff.
State: určuje stav stuffu když nastane event nebo človek bude 
interaktovat se stuffem
2 Observeru: Senzory vypíná/zapíná stuff pokud nastané nějaký 
event. Takže když nastane event tak tento event oznamuje o tom 
senzory
Builder: pattern pro home.
Iterator: iterujeme seznam stuffu 

### Poznamka
diagramclass.uml je podrobnější, ale je otevřitelné jenom pomocí IDEI
